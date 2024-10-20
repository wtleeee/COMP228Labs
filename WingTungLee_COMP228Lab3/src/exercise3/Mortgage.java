package exercise3;

abstract class Mortgage {
    //instance variables
    protected int mortgageNumber;
    protected String customerName;
    protected double amountOfMortgage;
    protected double interestRate;
    protected int term;

    //MortgageConstants
    protected static final int SHORT_TERM_YEARS = 1;
    protected static final int MEDIUM_TERM_YEARS = 3;
    protected static final int LONG_TERM_YEARS = 5;
    protected static final String BANK_NAME = "CIBC";
    protected static final double MAX_MORTGAGE_AMOUNT = 300000;

    //constructor
    public Mortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate, int term) {
        //mortgage amount cannot exceed maxMortgageAmount
        if(amountOfMortgage > MAX_MORTGAGE_AMOUNT){
            this.amountOfMortgage = MAX_MORTGAGE_AMOUNT;
        }else{
            this.amountOfMortgage = amountOfMortgage;
        }
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.interestRate = interestRate;

        if(term != SHORT_TERM_YEARS && term != MEDIUM_TERM_YEARS && term != LONG_TERM_YEARS) {//for invalid terms
            this.term = SHORT_TERM_YEARS;
        }else{
            this.term = term;
        }
    }
    //method
    public void getMortgageInfo() {
        System.out.println("Mortgage Number: " + mortgageNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Amount of Mortgage: $" + amountOfMortgage);
        System.out.println("Interest Rate: " + interestRate +"%");
        System.out.println("Term: " + term + " year(s)");
        System.out.println("Bank Name: " + BANK_NAME);
    }
}
