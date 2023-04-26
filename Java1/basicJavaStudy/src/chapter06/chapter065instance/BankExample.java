package chapter06.chapter065instance;

public class BankExample {
	public static void main(String[] args) {
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		
		a.balance = 100;
		b.balance -= 50;
		
		System.out.println(a.balance); //50 
		System.out.println(b.balance); //50	  같은 값을 공유 중 (ex. 은행 계좌에 사용하면 안됨. )
		
	}
}




