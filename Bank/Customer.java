package Bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer extends Demo {
	Scanner sc = new Scanner(System.in);
	private int accountNo;
	private String customerName;
	private String accountType;
	private double balance;
	private double minBalance;
	private String mobileNumber;
	private String emailId;
	private int atmPin;

	public Customer(int accountNo, String customerName, String accountType, double balance, double minBalance,
			String mobileNumber, String emailId, int atmPin) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.accountType = accountType;
		this.balance = balance;
		this.minBalance = minBalance;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.atmPin = atmPin;
	}

	public int setMobileNumber(String newMobileNumber) {
		System.out.println("Enter the phone number: ");
		return sc.nextInt();

	}

	public String setEmailId(String newEmailId) {
		System.out.println("Enter The email id: ");
		return sc.nextLine();

	}

	public void deposit(double amount) {
		if (amount > 50000) {
			System.out.print("Enter PAN Card number: ");
			Scanner scanner = new Scanner(System.in);
			String panCard = scanner.nextLine();
			System.out.println("PAN Card number: " + panCard);
		}

		balance += amount;
		System.out.println("Deposited " + amount + " successfully.");
	}

	// Withdraw money from the customer's account
	public void withdraw(double amount) {
		double availableBalance = balance - minBalance;
		if (amount > availableBalance) {
			System.out.println("Insufficient funds..!!!");
			return;
		}

		if (amount > 50000) {
			System.out.print("Enter PAN Card number: ");
			Scanner scanner = new Scanner(System.in);
			String panCard = scanner.nextLine();
			System.out.println("PAN Card number: " + panCard);
		}

		balance -= amount;
		System.out.println("Withdrawn " + amount + " successfully.");
	}

	// Show balance of the customer
	public void showBalance() {
		System.out.println("Account No: " + accountNo);
		System.out.println("Current Balance: " + balance);
	}

	// Transfer money to another account
	public void transferMoney(double amount) {
		if (amount > balance - minBalance) {
			System.out.println("Insufficient funds..!!!");
		}

		if (amount > 50000) {
			System.out.print("Enter PAN Card number: ");
			Scanner scanner = new Scanner(System.in);
			String panCard = scanner.nextLine();
			System.out.println("PAN Card number: " + panCard);
		}

		balance -= amount;
		System.out.println("Transferred " + amount + " successfully.");
	}

	static String getValidCustomerName(String customerName) {

		try {
			// creating object for BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern pattern = Pattern.compile("[^A-Za-z ]");

			do {

				// Match
				Matcher matcher = pattern.matcher(customerName);
				boolean finder = matcher.find(); // find() returns false if the string matches the pattern

				if (finder) {
					System.out.print("Name must contain only alphabets. Please re-enter name: ");
					customerName = br.readLine();
				} else if (customerName.length() < 3) {
					System.out.print("Name should contain minimum 3 characters. Please re-enter name: ");
					customerName = br.readLine();
				} else if (customerName.length() > 30) {
					System.out.print("Name contains more than 30 characters. Please re-enter name: ");
					customerName = br.readLine();
				} else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid name");
		}

		return customerName;
	}

	private static double getValidBalance(String balance) {

		try {
			// creating object for BufferedReader
			BufferedReader brBalance = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern patternBalance = Pattern.compile("[^0-9.-]");

			do {
				Matcher matcherBalance = patternBalance.matcher(balance);
				boolean balanceFinder = matcherBalance.find();

				if (balanceFinder) {
					System.out.print("Balance should contain only positive numeric values. Please re-enter balance: ");
					balance = brBalance.readLine();
				} else if (balance.length() > 8) {
					System.out.print("Balance cannot be greater than 100000000. Please re-enter: ");
					balance = brBalance.readLine();
				} else if (Double.parseDouble(balance) < 1000) {
					System.out.print("Sorry! Minimum balance should be 1000. Please re-enter: ");
					balance = brBalance.readLine();
				} else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid balance");
		}

		double doubleBalance = Double.parseDouble(balance);

		return doubleBalance;
	}

	private static double getValidBalance(Double balance) {

		try {
			BufferedReader brBalance = new BufferedReader(new InputStreamReader(System.in));

			do {
				if (balance.doubleValue() < 1000) {
					System.out.print("Sorry! Minimum balance should be 1000. Please re-enter: ");
					balance = Double.parseDouble(brBalance.readLine());
				} else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

		return balance;
	}

}
