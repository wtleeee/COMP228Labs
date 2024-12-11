package exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {
    public static void main(String[] args) {
        //implement the executorservice
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {
            //new account object
            Account a1 = new Account();
            // ArrayList to create a list of three or more Transaction object
            ArrayList<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(new Transaction(a1,500, "deposit"));
            transactions.add(new Transaction(a1,200.5, "withdraw"));
            transactions.add(new Transaction(a1,-300, "test"));
            transactions.add(new Transaction(a1,1000, "withdraw"));
            // Use method execute of ExecutorService to execute the threads
            for(Transaction t : transactions) {
                executorService.execute(t);
            }
            executorService.shutdown();
            //wait for all threads to complete
            if(executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All transactions executed successfully");
            } else {
                System.err.println("Timeout occurred while waiting for threads to complete");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing transactions: " + e.getMessage());
        }
    }
}
