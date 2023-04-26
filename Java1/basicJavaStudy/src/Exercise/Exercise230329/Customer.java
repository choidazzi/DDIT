package Exercise.Exercise230329;

public class Customer {
	private String firstName; // 이름
	private String lastName; // 성
	private BankAccount account; // 고객 소유 계좌
	// 생성자

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// 메서드
	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "이름: " + firstName + " " + lastName + ", 잔고: " + account.getBalance() + "원";
	}
}
