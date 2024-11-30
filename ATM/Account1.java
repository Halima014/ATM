package javaATM;

public class Account1 {
    private int customerNumber;
    private int pinNumber;
    private double balance;

    public Account1(int customerNumber, int pinNumber, double balance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.balance = balance;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}