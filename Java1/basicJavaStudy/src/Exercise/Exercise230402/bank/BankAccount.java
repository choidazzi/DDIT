package Exercise.Exercise230402.bank;

public abstract class BankAccount {
	protected int balance; //잔액 
	
	/*
	 * 계좌의 종류를 반환하는 메소드
	 * @return SavingsAccount => 저축예금, CheckingAccount => 당좌예금 
	 * */
	public abstract String getAccountType();

	public BankAccount(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) { //입금 
		balance += amount;
	}

	public boolean withdraw(int amount) { //출금 
		if(balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
		
	}
	
	public boolean transfer(int amount, BankAccount otherAccount) { //송금 
		if (withdraw(amount)) {
			otherAccount.deposit(amount); //출금 금액 = 다른 계좌 입금 금액 
			return true;
		}
		return false;
		
	}
	
	@Override
	public String toString() {
		return String.format("%,d", balance);
		//%,d : 3자리마다 , 찍어 줌. 
	}
}
