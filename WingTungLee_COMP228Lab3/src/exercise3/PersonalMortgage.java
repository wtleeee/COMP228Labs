package exercise3;

public class PersonalMortgage extends Mortgage {
    //extra interest rate constant
    private static final double EXTRA_INTEREST_RATE = 2;

    //constructor
    public PersonalMortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate, int term) {
        super(mortgageNumber, customerName, amountOfMortgage, interestRate+EXTRA_INTEREST_RATE, term);
    }
}
