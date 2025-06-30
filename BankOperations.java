import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            transactionHistory.add(date + " - Deposited: Rs " + amount);
            System.out.println("Successfully deposited Rs " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            transactionHistory.add(date + " - Withdrew: Rs " + amount);
            System.out.println("Successfully withdrew Rs " + amount);
        } else {
            System.out.println("Invalid withdrawal. Check your balance or amount.");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\nTransaction History for " + accountHolder + ":");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}

public class BankOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account myAccount = new Account("Siddhartha Vemula");

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: Rs ");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: Rs ");
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    myAccount.showBalance();
                    break;

                case 4:
                    myAccount.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using the bank system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
