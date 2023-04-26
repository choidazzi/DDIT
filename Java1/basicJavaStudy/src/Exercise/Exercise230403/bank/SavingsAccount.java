package Exercise.Exercise230403.bank;

public class SavingsAccount extends BankAccount{ //저축 
	//필드
	private double interestRate; //이자율 
	//생성자 
	public SavingsAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}
	//메서드 
	public void updateBalance(int period) {
		balance += balance * interestRate * period; 
	}
	@Override
	public String getAccountType() {
		return "저축예금";
	}
}
