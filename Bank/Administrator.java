package Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Administrator extends Demo{
	private Map<Integer, Customer> customers;

	public Administrator() {
		customers = new HashMap<>();
	}

	public void addCustomer(String customerName, String accountType, double balance, double minBalance,
			String mobileNumber, String emailId) {
		Random random = new Random();
		int accountNo = (int) (100000000L + (long) (random.nextDouble() * 900000000L));

		int atmPin = (int) (Math.random() * 9000) + 1000;
		Customer customer = new Customer(accountNo, customerName, accountType, balance, minBalance, mobileNumber,
				emailId, atmPin);
		customers.put(accountNo, customer);
		System.out.println("Customer added successfully with Account No: " + accountNo);
	}

	public void updateCustomerDetails(int accountNo, String newMobileNumber, String newEmailId) {
		if (customers.containsKey(accountNo)) {
			Customer customer = customers.get(accountNo);
			customer.setMobileNumber(newMobileNumber);
			customer.setEmailId(newEmailId);
			System.out.println("Customer details updated successfully.");
		} else {
			System.out.println("Account number not found..!!!");
		}
	}

	public void deleteCustomer(int accountNo) {
		if (customers.containsKey(accountNo)) {
			customers.remove(accountNo);
			System.out.println("Customer with Account No " + accountNo + " deleted successfully.");
		} else {
			System.out.println("Account number not found..!!!");
		}
	}

	public void displayAllCustomers() {
		for (Customer customer : customers.values()) {
			System.out.println(customer);
			System.out.println();
		}
	}

	public void displayCustomerDetails(int accountNo) {
		if (customers.containsKey(accountNo)) {
			System.out.println(customers.get(accountNo));
		} else {
			System.out.println("Account number not found..!!!");
		}
	}
}
