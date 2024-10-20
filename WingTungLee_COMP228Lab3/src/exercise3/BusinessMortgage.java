package exercise3;

public class BusinessMortgage extends Mortgage {
    //extra interest rate constant
    private static final double EXTRA_INTEREST_RATE = 1;
    //constructor
    public BusinessMortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate, int term) {
        super(mortgageNumber, customerName, amountOfMortgage, interestRate+EXTRA_INTEREST_RATE, term);
    }
}
