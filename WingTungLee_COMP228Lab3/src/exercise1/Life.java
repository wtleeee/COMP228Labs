package exercise1;

import static javax.swing.JOptionPane.showMessageDialog;

public class Life  extends Insurance{
    //constructor
    public Life(String insuranceType) {
        super("Life");
    }
    //methods
    @Override
    public void setInsuranceCost(double insuranceCost) {
        //set insurance cost for Life insurance
        this.insuranceCost=insuranceCost;
    }
    @Override
    public void displayInfo() {
        //display information of Life insurance
        showMessageDialog(null,"Health Insurance Type: "+this.insuranceType+"\nMonthly Cost: "+this.insuranceCost);
    }
}
