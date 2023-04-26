package Exercise.Exercise230329;
// is a : 상속 관계  & has a: 포함 관계 (점선) 
//ex. Student is a Human : 상속
//ex. Car has a Tire: 포함
//따라서, Customer has a BankAccount : 포함 && Bank has a Customer : 포함 

public class BankAccount {
	private int balance; //잔액 

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
	/*
	 * 이체 
	 * @param amount 이체금액 (이체금액이 잔액보다 클 수 없다. )
	 * @param otherAccount 이체할 계좌번호 
	 * @return
	 * */
	
	public boolean transfer(int amount, BankAccount otherAccount) { //송금 
		if (withdraw(amount)) {
			otherAccount.deposit(amount); //출금 금액 = 다른 계좌 입금 금액 
			return true;
		}
		return false;
		
	}
}
