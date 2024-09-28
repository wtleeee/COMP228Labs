package exercise3;

public class Travel {
    //three overloaded static methods
    //1. travel fee for renting a bike
    public static double travelFee(double hour) {
        final double bikeRate = 3; //renting fee is 3 dollars per hour
        return (hour * bikeRate);
    }
    //2. travel fee for driving
    public static double travelFee(double km, double fuelRate){
        return (km*fuelRate);
    }
    //3. travel fee for flying
    public static double travelFee(double miles, double fuelRate, String flyingClass){
        //rates for different classes
        final double economyRate = 1.2;
        final double businessRate = 1.8;
        final double firstClassRate = 2.5;
        //calculate the rates for different classes
        if(flyingClass== "Economy"){
            return (miles*fuelRate*economyRate);
        } else if (flyingClass =="Business") {
            return (miles * fuelRate * businessRate);
        }else{
            return (miles * fuelRate * firstClassRate);
        }
    }
}
