package Exercise.Exercise230403.bank;

public class Customer {
	//필드 
	private String firstName; // 이름
	private String lastName; // 성
	private BankAccount[] accounts; // 고객 소유 계좌
	private int numberOfAccounts;
	// 생성자

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new BankAccount[5];
	}

	// 메서드
	public BankAccount getAccount(int index) {
		return accounts [index];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public void addAccount(BankAccount account) {
		accounts [numberOfAccounts] = account;
		numberOfAccounts++;
	}
	@Override
	public String toString() {
		return String.format("%s %s", firstName,lastName);
		//return "이름: " + firstName + " " + lastName + ", 계좌의 갯수: " + numberOfAccounts;
	}
}