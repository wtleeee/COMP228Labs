package exercise1;

public class Transaction implements Runnable {

    //Instance variables
    private double amount;
    private String type; // "deposit" or "withdraw"
    private Account account;

    //constructor
    public Transaction(Account account, double amount, String type) {
        this.account = account;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public void run() {
        // if amount is less than or equal to 0
        if (amount <= 0) {
            System.out.println("Please enter a valid amount");
            return;
        }
        // perform transaction based on type
        if (type.equals("deposit")) {
            System.out.println(account.deposit(amount));
        } else if (type.equals("withdraw")) {
            System.out.println(account.withdraw(amount));
        }else{
            System.out.println("Invalid transaction type");
        }
    }
}
