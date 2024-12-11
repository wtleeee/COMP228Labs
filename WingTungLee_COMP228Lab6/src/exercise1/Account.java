package exercise1;

public class Account {
    //instance variable
    private double balance;

    //synchronized deposit method
    public synchronized String deposit(double amount) {
        balance += amount;
        return "New Balance after deposit: $" + String.format("%.2f", balance);
    }
    //synchronized withdraw method
    public synchronized String withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            return "New Balance after withdrawal: $" + String.format("%.2f", balance);
        }else{
            return "Insufficient balance";
        }

    }
}
