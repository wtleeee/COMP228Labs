package exercise2;

abstract class GameTester {
    //instance variables
    protected String name;
    protected boolean isFullTime;


    //constructor
    public GameTester(String name, boolean status) {
        this.name = name;
        this.isFullTime = status;
    }

    //abstract method
    public abstract double getSalary();

}
