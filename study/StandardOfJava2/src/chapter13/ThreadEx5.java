package chapter13;
/*
 	쓰레드를 하나 생성해서 두 개의 쓰레드가 작업을 하나씩 나누어서 수행한 후 실행결과를 비교 
 * */
public class ThreadEx5 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime = System.currentTimeMillis();
		
		for(int i = 0 ; i < 300; i++) System.out.printf("%s", new String("-"));

		System.out.println("소요시간1 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}

class ThreadEx5_1 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) System.out.printf("%s", new String("|"));
		
		System.out.println("소요시간2 : " + (System.currentTimeMillis() - ThreadEx5.startTime));

	}
}

/*
 		Ex4 보다 소요시간 김
 		why? 
 		1. 두 쓰레드가 번갈아가며 작업을 처리 => 작업전환시간 소요 
 		2. 한 쓰레드가 화면에 출력하고 있는 동안 다른 쓰레드는 출력이 끝나기를 기다려야 함. => 대기시간 발생 
 		
 */