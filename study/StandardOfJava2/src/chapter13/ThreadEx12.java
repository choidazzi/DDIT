package chapter13;

public class ThreadEx12 {
	public static void main(String[] args) {
		ThreadEx12_1 th1 = new ThreadEx12_1();
		ThreadEx12_2 th2 = new ThreadEx12_2();
		
		th1.start();
		th2.start();
		
//		try {
//			th1.sleep(2000);
//		} catch (InterruptedException e) {		}
//		
		System.out.println("<<main 종료>>");
	}
}

class ThreadEx12_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) 
			System.out.println("-");
		System.out.println("<<th1 종료>>");
		
		try {
			ThreadEx12_1.sleep(2000);
		} catch (InterruptedException e) {		}
		
	}
}
class ThreadEx12_2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) 
			System.out.println("|");
		System.out.println("<<th2 종료>>");
	}
}

/*
 	결과: th1 종료 => th2 종료 => main 종료 
 	왜 th1이 나중에 종료가 아님? 그 이유는 sleep()이 항상 현재 실행 중인 쓰레드에 대해 작동하기 때문에 
 	th1.sleep(2000) 을 호출해도 실제로 영향을 받는 것은 main메서드를 실행하는 main 쓰레드이다. 
 	그래서 sleep()은 static으로 선언, 참조변수를 이용하여 호출하는 것이 아닌, Thread.sleep(2000) 과 같이 해야함.
 * */
