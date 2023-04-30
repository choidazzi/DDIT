package chapter13;

import javax.swing.JOptionPane;

public class ThreadEx13 {
	public static void main(String[] args) throws Exception{
		Thread13_1 th1 = new Thread13_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt(); 		// interrupt() 를 호출하면, interrupted 상태가 true가 된다. 
		System.out.println("isInterrupted() : " + th1.isInterrupted()); 	// true 
	}
}

class Thread13_1 extends Thread {
	@Override
	public void run() {
		int i = 10;
		
		while (i !=0 && !isInterrupted()) {	//!isInterrupted() == true 일 때까지 반복 / 즉, isInterrputed() == false 일 때만 반복 / 즉, == true 면 중단 
			
			System.out.println(i--);
			for(long x = 0; x<2_500_000_000L;x++); //시간 지연 
		}
		System.out.println("카운트가 종료되었습니다. ");
	}
}