package in.ineuron.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.ineuron.bean.Account;
import in.ineuron.bean.AccountHolder;

public class AccountOperation {
	static Integer accNo = 37836737;
	static List<AccountHolder> list = new ArrayList<AccountHolder>();
	Scanner scan = new Scanner(System.in);

	public int createAccount() {
		System.out.println("-------------------------");
		System.out.println("Account Creation");
		System.out.println("-------------------------");
		System.out.println();

		try {
			System.out.print("Enter user name :: ");
			String username = scan.next();
			System.out.println();

			System.out.print("Enter user mobileNo :: ");
			Long mobileNo = scan.nextLong();
			System.out.println();

			System.out.print("Enter userId :: ");
			String userId = scan.next();
			System.out.println();

			System.out.print("Enter password :: ");
			String password = scan.next();
			System.out.println();

			Float balance = 0.0f;
			accNo++;

			String accBranch = "Kolhapur";
			String accType = "saving";

			Account account = new Account(accNo, accBranch, accType);
			AccountHolder accHolder = new AccountHolder(username, mobileNo, userId, password, account, balance);
			
			displayAccount(accHolder);
			list.add(accHolder);

		} catch (Exception e) {
			System.out.println("Enter correct input ");
			return -1;
		}
		return 1;
	}

	public boolean login() {
		System.out.println("-------------------------");
		System.out.println("Login");
		System.out.println("-------------------------");

		try {
			System.out.print("Enter username :: ");
			String username = scan.next();
			System.out.println();
			System.out.print("Enter password :: ");
			String password = scan.next();

			for (AccountHolder ah : list) {
				if (ah.getUserId().equals(username) && password.equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Enter correct input ");
			return false;
		}
		return false;
	}

	public void displayAccount(AccountHolder ah) {
		System.out.println("-------------------------");
		System.out.println("Account Details");
		System.out.println("-------------------------");

		System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", "Name", "Mobile Number", "Account Number",
				"Account Type", "Branch"));

		System.out.println();

		System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", ah.getName(), ah.getMobileNumber(),
				ah.getAccount().getAccNo(), ah.getAccount().getAccType(), ah.getAccount().getAccBranch()));

		return;
	}
}
