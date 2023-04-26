package chapter06.chapter065instance;

public class BankAccount {
	static int balance; //잔액
	String name;
	
	//입금 메소드 
	static void deposit(int amount) {
		balance +=  amount;
		BankAccount account = new BankAccount(); //해결 1 
		account.name = "홍길동"; 
		// name 이 static 이 아니라서 
		// name 이 어디인지 몰라서 
		//this. 못씀. static을 쓰면 자기자신을 의미. 
		//해결2 . name 에 staitic 붙이기. 비추. 메모리적 중복 있을 수 있음. 
	}
	//출금 메소드 
	void withdraw(int amount) {
		balance -= amount;
	}
}
