package exercise2;

public class FullTimeGameTester extends GameTester {
    //constructor
    public FullTimeGameTester(String name) {
        super(name, true);
    }
    //method to get the salary
    @Override
    public double getSalary() {
        //variables
        double salary = 3000;
        return salary;
    }
}
