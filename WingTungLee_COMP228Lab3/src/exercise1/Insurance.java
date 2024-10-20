package exercise1;

abstract class Insurance {
    //instance variables
    protected String insuranceType;
    protected double insuranceCost;

    //get methods for variables
    public String getInsuranceType() {
        return insuranceType;
    }
    public double getInsuranceCost() {
        return insuranceCost;
    }
    //abstract methods
    public abstract void setInsuranceCost(double insuranceCost);
    public abstract void displayInfo();

    //constructor
    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }


}
