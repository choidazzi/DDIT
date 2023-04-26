package Exercise.Exercise230403.bank;

public class CheckingAccount extends BankAccount {
	//필드 
	private SavingsAccount protectedBy;
	//생성자 
	public CheckingAccount(int balance) {
		super(balance);
	}
	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}
	//메소드
	@Override
	public boolean withdraw(int amount) {
		if (amount > balance) {
			protectedBy.balance -= amount - balance; //초과하는 만큼 저축 계좌에서 인출 
			balance = 0;
			return true;
		}
		return super.withdraw(amount);
	}
	@Override
	public String getAccountType() {
		return "당좌예금";
	}
}
