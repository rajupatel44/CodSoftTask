package Task3;


import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit-successful. New balance: " + balance);
        } else {
            System.out.println("Invalid-deposit-amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid-withdrawal-amount or insufficient-balance.");
        }
    }
}

// ATM class with user interface
class ATM {
    private final BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void operateATM() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you! ( उपयोग करने के लिए धन्यवाद)");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}

// Main class to demonstrate the ATM system
public class Main {
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance of 1000
        BankAccount userAccount = new BankAccount(10000);

        // Create an ATM with the user's account
        ATM atm = new ATM(userAccount);

        // Operate the ATM
        atm.operateATM();
    }
}

