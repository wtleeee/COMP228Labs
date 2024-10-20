package exercise1;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {
        //create Insurance array of 2 items
        Insurance[] insurances = new Insurance[2];

        //loop to ask user about the type of insurance
        for (int i = 0; i < insurances.length; i++) {
            String type = showInputDialog("Please enter insurance type:");

            //create object
            if (type.equalsIgnoreCase("health")) {
                Insurance newInsurance = new Health("Health");
                insurances[i] = newInsurance; //add the new object to the array
                
            } else if (type.equalsIgnoreCase("life")) {
                Insurance newInsurance = new Life("Life");
                insurances[i] = newInsurance; //add the new object to the array
            }else{
                showMessageDialog(null,"Invalid insurance type");
                break;
            }
            //to ask user about monthly fee, to set it, and to display insurance information
            Double monthlyFee = Double.valueOf(showInputDialog("Please enter monthly fee:"));
            insurances[i].setInsuranceCost(monthlyFee); //set the monthly fee
            insurances[i].displayInfo(); //display the insurance information
        }
    }
}
