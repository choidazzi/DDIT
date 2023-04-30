package chapter13;

public class ThreadEx10 implements Runnable{
	static boolean autoSave = false;
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());
		/*
		 	데몬 쓰레드 
		 	: 일반 쓰레드의 작업을 돕는 보조적인 역할 
		 	: 일반 쓰레드가 종료되면, 데몬 쓰레드 또한 종료된다. (존재의미가 사라짐)
		 * */
		t.setDaemon(true);	// 이 부분이 없다면, 영원히 종료되지 않는다. 무조건 start()메서드 호출 이전에 실행되어야 한다. 
		t.start();
		
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { 	}
			
			System.out.println(i);
			
			if (i == 5) {
				autoSave = true;
			}
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);//3초마다
			} catch (InterruptedException e) { }
			
			//autoSave의 값이 true 이면 autoSave() 를 호출한다. 
			if (autoSave) {
				autoSave();
			}
		}

	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
