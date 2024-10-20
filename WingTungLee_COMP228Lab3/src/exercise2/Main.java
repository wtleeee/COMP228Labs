package exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter gamer name: ");
        String name = scanner.next();
        System.out.print("Enter gamer type - 1 for Full Time, 2 for Part Time: ");
        int type = scanner.nextInt();
        // if the type is not 1 or 2
        if(type != 1 && type != 2){
            System.out.print("Invalid gamer type.");
        }else{
            double salary = 0.0;
            if(type == 1){
                //create Gametester object
                GameTester fullTimeGamer = new FullTimeGameTester(name);
                salary = fullTimeGamer.getSalary();
                System.out.println("Full time gamer profile created.");
            } else{ //for part time
                //ask for working hours
                System.out.print("Enter number of working hours: ");
                int hours = scanner.nextInt();
                //create Gametester object
                GameTester partTimeGamer = new PartTimeGameTester(name, hours);
                salary = partTimeGamer.getSalary();
                System.out.println("Part time gamer profile created.");
            }
            System.out.println("Gamer salary: $"+salary);
        }
        scanner.close();
    }
}
