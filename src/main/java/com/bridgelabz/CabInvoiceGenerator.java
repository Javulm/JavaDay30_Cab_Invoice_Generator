package com.bridgelabz;

public class CabInvoiceGenerator {
    private final static double COST_PER_KM = 10;
    private final static double COST_PER_MINUTE = 1;
    private final static int MINIMUM_FARE = 5;
    private final static double PREMIUM_COST_PER_KM = 15;
    private final static double PREMIUM_COST_PER_MINUTE = 2;
    private final static int PREMIUM_MINIMUM_FARE = 20;

    public static double calculateFare(double distance, double time, Ride.RideType rideType) {
       switch (rideType){
           case NORMAL:
               double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
               return totalFare <= MINIMUM_FARE ? MINIMUM_FARE : totalFare;
           case PREMIUM:
               double premiumTotalFare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MINUTE;
               return premiumTotalFare <= PREMIUM_MINIMUM_FARE ? PREMIUM_MINIMUM_FARE : premiumTotalFare;
       }
       return 0.0;
    }

    public static double calculateFare(Ride[] rides) {
        double aggregateFare = 0.0;
        for(Ride ride : rides){
            aggregateFare += calculateFare(ride.getDistance(),ride.getTime(), ride.getRideType());
        }
        return aggregateFare;
    }

    public static Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalRides = rides.length;
        double averageFare = totalFare/totalRides;
        System.out.println("fare:" + totalFare + " Ride:" + totalRides + " avg: " + averageFare);
        return new Invoice(totalFare, totalRides, averageFare);
    }

    public static void main(String[] args) {
        Ride[] ride= {new Ride(10, 4, Ride.RideType.PREMIUM), new Ride(20, 3, Ride.RideType.PREMIUM), new Ride(0.2, 2, Ride.RideType.PREMIUM), new Ride(10, 5, Ride.RideType.PREMIUM)};
        double total = CabInvoiceGenerator.calculateFare(ride);
        Invoice invoice = generateInvoice(ride);
        System.out.println(total);
        System.out.println(invoice);
    }
}
