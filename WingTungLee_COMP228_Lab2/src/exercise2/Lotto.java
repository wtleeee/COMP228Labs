package exercise2;

import java.util.Random;

public class Lotto {
    //declare instance variable lottoArray
    private static int[] lottoArray = new int[3];
    //setter for lottoArray
    public static void setLottoArray(int[] lottoArray) {
        Lotto.lottoArray = lottoArray;
    }
    //getter for lottoArray
    public static int[] getLottoArray() {
        return lottoArray;
    }
    //constructor to randomly populates the array
    public Lotto() {
        Random rand = new Random();
        int randomNumber;
        for (int i=0;i< lottoArray.length;i++){//add three numbers to lottoArray
            randomNumber=rand.nextInt(9)+1;//generate a random number from 1 to 9
            lottoArray[i]=randomNumber;
        }
    }
    //method to return the lottoArray
    public static int[] returnArray(){
        return lottoArray;
    }
}
