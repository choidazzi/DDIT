package Exercise.BankAdvanced;

public class Bank {
	//필드 
	private Customer[] customers; //은행의 고객 목록
	private int numberOfCustomers; // 은행의 고객 수 
	//생성자 
	public Bank() {
		customers = new Customer[10];
	}
	//메서드 
	public void addCustomer(Customer customer) {
		customers[numberOfCustomers] = customer;
		numberOfCustomers++;
	}
	public Customer[] getCustomers() {
		return customers;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	Customer getCustomer(int index) {
		return customers[index]; //index 번째 고객 반환 
	}
	
}
