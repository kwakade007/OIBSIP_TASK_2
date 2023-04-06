package First_ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private static String accountNumber = "123456";
    private static int pin = 1234;
    private static int balance = 5000;
    private static ArrayList<String> transactionHistory = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Please enter your account number:");
            String userAccountNumber = scanner.nextLine();
            System.out.println("Please enter your PIN:");
            int userPin = scanner.nextInt();
            scanner.nextLine();

            if (userAccountNumber.equals(accountNumber) && userPin == pin) {
                loggedIn = true;
                System.out.println("Login successful");
            } else {
                System.out.println("Invalid account number or PIN. Please try again.");
            }
        }

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Transaction History");
            System.out.println("5. Quit");
            

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to withdraw:");
                    int withdrawAmount = scanner.nextInt();
                    if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance");
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("Transaction successful");
                        System.out.println("Remaining balance: " + balance);
                        transactionHistory.add("Withdrawal of " + withdrawAmount + " from account number " + accountNumber);
                    }
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit:");
                    int depositAmount = scanner.nextInt();
                    balance += depositAmount;
                    System.out.println("Transaction successful");
                    System.out.println("New balance: " + balance);
                    transactionHistory.add("Deposit of " + depositAmount + " to account number " + accountNumber);
                    break;
                case 3:
                    System.out.println("Your balance: " + balance);
                    break;
                case 4:
                    System.out.println("Transaction History:");
                    for (String transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM");
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

