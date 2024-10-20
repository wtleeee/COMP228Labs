package exercise1;

import static javax.swing.JOptionPane.showMessageDialog;

public class Health extends Insurance{
    //constructor
    public Health(String insuranceType) {
        super("Health");
    }
    //methods
    @Override
    public void setInsuranceCost(double insuranceCost) {
        //set insurance cost for Health insurance
        this.insuranceCost=insuranceCost;
    }
    @Override
    public void displayInfo() {
         //display information of Health insurance
        showMessageDialog(null,"Health Insurance Type: "+this.insuranceType+"\nMonthly Cost: "+this.insuranceCost);
    }
}
