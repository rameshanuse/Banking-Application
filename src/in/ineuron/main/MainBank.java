package in.ineuron.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.ineuron.bean.AccountHolder;
import in.ineuron.operations.AccountOperation;
import in.ineuron.operations.BankOperations;

public class MainBank {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer option = 0;
		Integer invalid = 0;

		List<AccountHolder> list = new ArrayList<AccountHolder>();
		AccountOperation accOperation = new AccountOperation();

		System.out.println("****************************");
		System.out.println("Welcome to Kolhapur bank");
		System.out.println("****************************");

		while (true) {
			if (invalid > 3) {
				System.out.println("YOU REACHED MAXIMUM LIMIT TRY AGAIN LATER...");
				System.exit(0);
			}
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.println("1. Account Creation");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("--------------------------------------------------------");

			try {
				System.out.print("Enter your choice :: ");
				option = scan.nextInt();
				scan.nextLine();

				switch (option) {
				case 1: {
					int status = accOperation.createAccount();
					if (status == 0) {
						System.out.println();
						invalid = 0;
						System.out.println("Account created!...");
						boolean loginStatus = accOperation.login();
						if (loginStatus) {
							System.out.println();
							System.out.println("Login success!...");
							System.out.println();
							operations();
							continue;
						} else {
							System.out.println();
							System.out.println("Invalid credential!...Try again");
							invalid++;
						}
					} else {
						continue;
					}
					break;
				}
				case 2: {
					boolean loginStatus = accOperation.login();
					if (loginStatus) {
						System.out.println();
						System.out.println("Login success!...");
						System.out.println();
						operations();
						continue;
					} else {
						invalid++;
						System.out.println("Invalid credential!...Try again");
					}
					break;
				}
				case 3: {
					System.out.println("***********Thanks for using Application************ ");
					System.exit(0);
				}
				default: {
					System.out.println("Invalid input please enter correct choise");
					break;
				}
				}
			} catch (Exception e) {
				System.out.println("Entered invalid input try agin!");
				break;
			}
		}

	}

	public static void operations() {
		Scanner scan = new Scanner(System.in);
		BankOperations bankOperations = new BankOperations();
		Integer choice = 0;

		while (true) {
			System.out.println("Our Services");
			System.out.println("1. Check Balance ");
			System.out.println("2. Deposit ");
			System.out.println("3. Withdraw ");
			System.out.println("4. HomePage ");
			System.out.println();

			try {
				System.out.print("Make your choice :: ");
				choice = scan.nextInt();
				scan.nextLine();

				switch (choice) {
				case 1: {
					System.out.print("Enter Account number :: ");
					int accNumber = scan.nextInt();
					Float balance = bankOperations.chechBalance(accNumber);
					if(balance != -1.0) {
						System.out.println("Balance in your account is :: "+balance);
						System.out.println();
					} else {
						System.out.println("Account not found");
					}
					break;
					
				}
				case 2:{
					System.out.print("Enter Account number :: ");
					int accNumber = scan.nextInt();
					
					System.out.print("Enter the Amount :: ");
					float amt = scan.nextFloat();
					Float balance = bankOperations.deposit(accNumber, amt);
					if(balance != -1.0) {
						System.out.println("Amount deposited successfully...");
						System.out.println("Balance in your account is :: "+balance);
						System.out.println();
					} else {
						System.out.println("Account not found");
						System.out.println();
					}
					break;
				}
				case 3: {
					System.out.print("Enter Account number :: ");
					int accNumber = scan.nextInt();
					System.out.print("Enter Amount to Withdraw :: ");
					float amt = scan.nextFloat();
					
					Float balance = bankOperations.withdraw(accNumber, amt);
					if(balance == -2.0) {
						System.out.println("Not Sufficient Balance to Withdraw");
					} else if(balance != -1.0) {
						System.out.println("Amount withdrawn successfully...");
						System.out.println("Balance in your account is :: "+balance);
						System.out.println();
					}else {
						System.out.println("Account not found");
						System.out.println();
					}
					break;
				}
				case 4: {
					System.out.println("Logged out successfully...");
					return;
				}
				default : {
					System.out.println("Invalid input please enter correct choice");
					continue;
				}
				}
			} catch (Exception e) {
				System.out.println("Entered invalid input try agin!");
				break;
			}
		}
	}

}
