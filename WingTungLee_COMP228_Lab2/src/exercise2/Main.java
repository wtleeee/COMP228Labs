package exercise2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int userInput = Integer.parseInt(JOptionPane.showInputDialog("Please choose a number between 3 and 27"));
        int winningNumber=0;
        boolean userwin =false;
        for(int i =0;i<5;i++){
            int[] lottoArray=Lotto.returnArray();
            for(int j=0;j<lottoArray.length;j++){
                winningNumber+=lottoArray[j];
            }
            if(winningNumber==userInput){
                JOptionPane.showMessageDialog(null,"Congratulations! You win!");
                userwin=true;
                break;
            }
            winningNumber =0;
        }
        if(!userwin){
            JOptionPane.showMessageDialog(null,"Sorry you lost.");
        }
    }
}