package com.assignment;

import java.util.Scanner;

public class AccountTest {
	String accno;
	String name;
	long balance;
	long amt;

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How Many Customer You Want to Input : ");
		int n = sc.nextInt();
		AccountTest[] C = new AccountTest[n];
		for (int i = 0; i < C.length; i++) {
			C[i] = new AccountTest();
			C[i].openAccount();
		}

		int choice;
		do {
			System.out.println(
					"Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.E xit ");
			System.out.println("Ur Choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				for (AccountTest bank : C) {
					bank.showAccount();
				}
				break;

			case 2:
				System.out.print("Enter Account No. You Want to Search...: ");
				String acn = sc.next();
				boolean found = false;
				for (AccountTest bank : C) {
					found = ((AccountTest) bank).search(acn);
					if (found) {
						break;
					}
				}
				if (!found) {
					System.out.println("Search Failed..Account Not Exist..");
				}
				break;

			case 3:
				System.out.print("Enter Account No : ");
				acn = sc.next();
				found = false;
				for (AccountTest bank : C) {
					found = ((AccountTest) bank).search(acn);
					if (found) {
						((AccountTest) bank).deposit();
						break;
					}
				}
				if (!found) {
					System.out.println("Search Failed..Account Not Exist..");
				}
				break;

			case 4:
				System.out.print("Enter Account No : ");
				acn = sc.next();
				found = false;
				for (AccountTest bank : C) {
					found = bank.search(acn);
					if (found) {
						bank.withdrawal();
						break;
					}
				}
				if (!found) {
					System.out.println("Search Failed..Account Not Exist..");
				}
				break;

			case 5:
				System.out.println("Good Bye..");
				break;
			}
		} while (choice != 5);
	}

	void openAccount() {
		System.out.print("Enter Account No: ");

		accno = sc.next();
		System.out.print("Enter Name: ");
		name = sc.next();
		System.out.print("Enter Balance: ");
		balance = sc.nextLong();

	}

	void showAccount() {
		System.out.println(accno + "," + name + "," + balance);
	}

	void deposit() {
		long amt;
		System.out.println("Enter Amount You Want to Deposit : ");
		amt = sc.nextLong();
		balance = balance + amt;
	}

	void withdrawal() {
		long amt;
		System.out.println("Enter Amount You Want to withdraw : ");
		amt = sc.nextLong();
		if (balance >= amt) {
			balance = balance - amt;
		} else {
			System.out.println("Less Balance..Transaction Failed..");

		}
	}

	boolean search(String acn) {
		if (accno.equals(acn)) {
			showAccount();
			return (true);
		}
		return (false);
	}

}