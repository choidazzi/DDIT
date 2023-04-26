package chapter13;

public class ThreadEx1 {
	public static void main(String[] args) {
		// Thread의 자손(extends) 클래스의 인스턴스를 생성 
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		/*
		 	Runnable을 구현한 경우, Runnable 인터페이스를 구현한 클래스의 인스턴스를 
		 	생성한 다음, 이 인스턴스를 Thread클래스의 생성자의 매개변수로 제공해야한다. 
		 	
		 */
		
		//Runnable을 구현(implements)한 클래스의 인스턴스를 생성 
		Runnable r = new ThreadEx1_2();
		// 생성자 Thread(Runnable target)
		Thread t2 = new Thread(r);		
		
		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); //조상인 Thread의 getName()을 호출 
		}
	}
}

class ThreadEx1_2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			//Thread.currentThread() -현재 실행 중인 Thread를 반환한다. 
			System.out.println(Thread.currentThread().getName()); //조상인 Thread의 getName()을 호출 
		}
	}
} 