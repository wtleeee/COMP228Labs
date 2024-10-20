package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //crate an array of 3 mortgages
        Mortgage[] mortgages = new Mortgage[3];
        //prompt for current interest rate
        System.out.print("Enter current interest rate (%): ");
        double currentInterestRate = scanner.nextDouble();
        //loop to prompt user for mortgage information and create mortgages
        for (int i = 0; i < mortgages.length; i++) {
            //prompt for mortgage information
            System.out.println("-----------------");
            System.out.println("Mortgage " + (i + 1)+":");
            System.out.print("Mortgage number: ");
            int mortgageNumber = scanner.nextInt();
            System.out.print("Customer name: ");
            String customerName = scanner.next();
            System.out.print("Amount of mortgage (Maximum $300,000): ");
            double amountOfMortgage = scanner.nextDouble();

            System.out.print("Term: ");
            int term = scanner.nextInt();
            System.out.print("Enter mortgage type (1 for Business, 2 for Personal): ");
            int mortgageType = scanner.nextInt();
            //create mortgage object and add to array
            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amountOfMortgage, currentInterestRate, term);
            } else if (mortgageType == 2) {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amountOfMortgage, currentInterestRate, term);
            }
        }
        //display all mortgages
        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("******************");
            System.out.println("Information for mortgage " + (i+1)+ ":");
            mortgages[i].getMortgageInfo();
        }
        scanner.close();
    }
}
