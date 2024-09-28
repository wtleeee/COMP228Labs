package exercise3;

public class Main {
    public static void main(String[] args) {
        //the travel fee for renting the bike for 2 hours
        double cyclingFee = Travel.travelFee(2);
        //the travel fee for driving for 4km, with fuel rate $30 per km
        double drivingFee = Travel.travelFee(4,30);
        //the travel fee for flying in economy class, for 500 miles and with a rate of $2 per mile
        double flyingFee = Travel.travelFee(500,2,"Economy");
        System.out.printf("cycling fee: $%.1f%ndriving fee: $%.1f%nflying fee: $%.1f", cyclingFee, drivingFee, flyingFee);
    }
}