package chapter13;

public class ThreadEx20 {
	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		gc.setDaemon(true);
		gc.start();
		
		int requiredMemory = 0;
		
		for (int i = 0; i < 20; i++) {
			requiredMemory = (int) (Math.random() * 10) * 20;
			
			// 필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60% 이상을 사용했을 경우 gc를 깨운다.
			if (gc.freeMemory() < requiredMemory
					|| gc.freeMemory() < gc.totalMemory() * 0.4) {
				// 잠자고 있는 쓰레드 gc를 깨운다.
				gc.interrupt();
				try {
					// gc가 interrupt() 에 의해 깨어났음에도 gc()가 수행되기 이전에 main쓰레드의 작업이 수행되어 메모리를 사용하기 때문  
					// gc가 0.1초 동안 수행될 수 있도록 (main 쓰레드가 gc 쓰레드가 종료될 (0.1초) 동안 기다린다. 
					gc.join(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory : " + gc.usedMemory);
		}
	}
}

class ThreadEx20_1 extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		while (true) {
			try {
				// 10 초 기다리기 
				Thread.sleep(10 * 1000); 
			} catch (InterruptedException e) {
				System.out.println("Awaken by interrupt().");
			}
			// garbage collection 을 수행한다.
			gc();
			System.out.println("Garbage Collected. Free Memory : " +freeMemory());
		}
	}

	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) usedMemory = 0;
	}

	public int totalMemory() {return MAX_MEMORY; }
	public int freeMemory() {return MAX_MEMORY - usedMemory;}

}
