package com.bridgelabz;

public class CabInvoiceGenerator {
    private final static double COST_PER_KM = 10;
    private final static double COST_PER_MINUTE = 1;
    public static double calculateFare(double distance, double time) {
    double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
    return totalFare<=5 ? 5 : totalFare;
    }

    public static double calculateFare(Ride[] rides) {
        double aggregateFare = 0.0;
        for(Ride ride : rides){
            aggregateFare += calculateFare(ride.getDistance(),ride.getTime());
        }
        return aggregateFare;
    }

    public static Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalRides = rides.length;
        double averageFare = totalFare/totalRides;
        return new Invoice(totalFare, totalRides, averageFare);
    }
}
