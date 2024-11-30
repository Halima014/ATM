package javaATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionMenu {
    private Scanner menuInput = new Scanner(System.in);
    private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private HashMap<Integer, Account1> accounts = new HashMap<>();

    public OptionMenu() {
        // Sample customer data
        accounts.put(952141, new Account1(952141, 191904, 1000.00));
        accounts.put(989947, new Account1(989947, 71976, 500.00));
    }

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                System.out.println("Welcome to the ATM project!");
                System.out.print("Enter your customer Number: ");
                int customerNumber = menuInput.nextInt();
                System.out.print("Enter your PIN Number: ");
                int pinNumber = menuInput.nextInt();

                Account1 account = accounts.get(customerNumber);
                if (account != null && account.getPinNumber() == pinNumber) {
                    getAccountType(account);
                    x = 0; // Exit loop on successful login
                } else {
                    System.out.println("\nWrong Customer Number or PIN Number\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.\n");
                menuInput.next(); // Clear the invalid input
            }
        } while (x == 1);
    }

    private void getAccountType(Account1 account) {
        int selection;
        do {
            System.out.println("Select the Account you want to Access: ");
            System.out.println("Type 1 - Check Balance");
            System.out.println("Type 2 - Deposit Funds");
            System.out.println("Type 3 - Withdraw Funds");
            System.out.println("Type 4 - Exit");
            System.out.print("Choice: ");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Your balance is: " + moneyFormat.format(account.getBalance()));
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = menuInput.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Successfully deposited: " + moneyFormat.format(depositAmount));
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = menuInput.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Successfully withdrew: " + moneyFormat.format(withdrawAmount));
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using this ATM. Bye.");
                    break;

                default:
                    System.out.println("\nInvalid Choice.\n");
            }
        } while (selection != 4);
    }
}