package kr.or.ddit.basic;

// 자동 저장하는 데몬 스레드 연습
public class ThreadTest08 {
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		autoSave.setDaemon(true); 		// 데몬 쓰레드로 설정하기 => 반드시 start()메서드 호출 전에 실행해야 한다.
		System.out.println("데몬 스레드 여부: " + autoSave.isDaemon());
		autoSave.start();

		try {
			for (int i = 1; i <= 20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("메인스레드 종료");
	}

}

// 3초에 한번씩 자동으로 저장하는 스레드
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장합니다");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			save();
		}
	}
}