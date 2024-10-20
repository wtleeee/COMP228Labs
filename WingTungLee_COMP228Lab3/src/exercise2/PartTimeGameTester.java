package exercise2;

public class PartTimeGameTester extends GameTester {
    //variable
    protected int hoursWorked;

    //constructor
    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }
    //method to get the salary
    @Override
    public double getSalary() {
        return hoursWorked * 20;
    }
}
