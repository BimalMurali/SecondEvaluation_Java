package Bank;

import java.util.Scanner;

class Main {
	private Administrator admin;

	public Main() {
		admin = new Administrator();
	}

	// Main method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main bank = new Main();
		Administrator obj = new Administrator();
		Customer obj1 = new Customer(0, null, null, 0, 0, null, null, 0);
        try {
		while (true) {
			int op;
			System.out.println("Bank Transactions Menu:");
			System.out.println("1.Admin 2.Customer Enter the option");
			
			op = scanner.nextInt();
			if (op == 1) {
				System.out.println("Welcome to Admin page ");
				System.out.println("1. Add a New Customer");
				System.out.println("2. Update Customer Details");
				System.out.println("3. Delete a Customer");
				System.out.println("4. Display List of All Customers");
				System.out.println("5. Display Customer Details");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline

				switch (choice) {
				case 1:
					System.out.print("Enter Customer Name: ");
					String name = scanner.nextLine();
					obj1.getValidCustomerName(name);
					System.out.print("Enter Account Type (Savings/Current): ");
					String accountType = scanner.nextLine();
					System.out.print("Enter Initial Balance: ");
					double balance = scanner.nextDouble();
					System.out.print("Enter Minimum Balance: ");
					double minBalance = scanner.nextDouble();
					scanner.nextLine(); // Consume the newline
					System.out.print("Enter Mobile Number: ");
					String mobileNumber = scanner.nextLine();
					System.out.print("Enter Email Id: ");
					String emailId = scanner.nextLine();
					bank.admin.addCustomer(name, accountType, balance, minBalance, mobileNumber, emailId);
					break;
				case 2:
					System.out.print("Enter Account No: ");
					int accountNo = scanner.nextInt();
					scanner.nextLine(); // Consume the newline
					System.out.print("Enter New Mobile Number: ");
					String newMobileNumber = scanner.nextLine();
					System.out.print("Enter New Email Id: ");
					String newEmailId = scanner.nextLine();
					bank.admin.updateCustomerDetails(accountNo, newMobileNumber, newEmailId);
					break;
				case 3:
					System.out.print("Enter Account No to Delete: ");
					int deleteAccountNo = scanner.nextInt();
					bank.admin.deleteCustomer(deleteAccountNo);
					break;
				case 4:
					System.out.println("List of All Customers:");
					bank.admin.displayAllCustomers();
					break;
				case 5:
					System.out.print("Enter Account No to Display Details: ");
					int displayAccountNo = scanner.nextInt();
					bank.admin.displayCustomerDetails(displayAccountNo);
					break;
				case 6:
					System.out.println("Exiting...");
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			} else if (op == 2) {
				System.out.println("Welcome to Customer Page");
				System.out.println("1. Deposit Money");
				System.out.println("2. Withdraw Money");
				System.out.println("3. Show Balance");
				System.out.println("4. Transfer Money");
				System.out.print("Enter your choice: ");
				int choice1 = scanner.nextInt();
				scanner.nextLine();

				switch (choice1) {
				case 1:
					System.out.println("Enter the account number:");
					int acc = scanner.nextInt();
					System.out.print("Enter amount to deposit: ");
					double deposit = scanner.nextInt();

					obj1.deposit(deposit);
					break;
				case 2:
					System.out.println("Enter the account number:");
					int ac1 = scanner.nextInt();
					System.out.print("Enter amount to withdraw: ");
					double withdraw = scanner.nextInt();

					obj1.withdraw(withdraw);
					break;
				case 3:
					System.out.println("Enter the account number:");
					int ac2 = scanner.nextInt();
					obj1.showBalance();
					obj1.getValidBalance(ac2);
					break;

				case 4:
					System.out.println("Enter the account number:");
					int ac3 = scanner.nextInt();
					System.out.print("Enter amount to transfer: ");
					double transfer = scanner.nextInt();
					obj1.transferMoney(transfer);
					bank.admin.displayAllCustomers();
					break;
				
				}

			}
			else {
				System.out.println("Ivalid Option");
				System.out.println("Exiting...");
				System.exit(0);
			}
		}
        }catch(Exception e ) {
        	System.out.println("Enter valid option and the error is :"+e);
        }
	}
}
