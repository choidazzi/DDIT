package chapter13;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
	public static void main(String[] args) {
		ThreadEx11_1 t1 = new ThreadEx11_1("Thread1");
		ThreadEx11_2 t2 = new ThreadEx11_2("Thread2");
		
		t1.start();
		t2.start();
	}
}

class ThreadEx11_1 extends Thread {
	//생성자 
	public ThreadEx11_1(String name) {
		super(name);	//조상 클래스 
	}
	
	@Override
	public void run() {
		try {
			sleep(5000);			// 5초동안 기다린다. 
		} catch (InterruptedException e) {  }
	}
}

class ThreadEx11_2 extends Thread {
	//생성자 
		public ThreadEx11_2(String name) {
			super(name);	//조상 클래스 
		}

	@Override
	public void run() {
		/*
		 	getAllStackTraces() : 실행 중 또는 대기상태, 즉 작업이 완료되지 않은 모든 쓰레드의 호출스택을 출력할 수 있다. 
		 * */
		
		Map map = getAllStackTraces();			//map (K,V) 키는 중복 안됨, 값은 중복 허용, 순서 유지 X 
		Iterator it = map.keySet().iterator();
		//keySet() 		: map 에 있는 모든 key객체를 반환한다.  
		//iterator() 	: 읽어온다.  
		
		int x = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread)obj;
			StackTraceElement[] ste = (StackTraceElement[]) map.get(obj);
			
			System.out.println("[" + ++x + "] name : " + t.getName() + ", group : " + t.getThreadGroup().getName() + ", daemon : " + t.isDaemon() );
			
			for(int i = 0; i <ste.length ; i++) {
				System.out.println(ste[i]);
			}
			System.out.println();
		}
	}
}







