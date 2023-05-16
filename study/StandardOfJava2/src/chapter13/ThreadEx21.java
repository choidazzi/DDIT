package chapter13;

public class ThreadEx21 {
	public static void main(String[] args) {
		Runnable r = new Runnable21_1();
		// Thread그룹에 참조되므로 gc 대상이 아님 
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	//출금 
	public synchronized void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
	}
}

class Runnable21_1 implements Runnable {
	Account acc = new Account();
	
	@Override
	public void run() {
		while (acc.getBalance() > 0) {
			//100, 200, 300 중 한 값을 임의 선택해서 출금 (withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}//run
		
	}
}
