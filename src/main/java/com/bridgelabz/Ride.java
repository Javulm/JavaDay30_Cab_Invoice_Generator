package com.bridgelabz;

public class Ride {
    public enum RideType{
        NORMAL, PREMIUM;
    }
    private double distance;
    private double time;
    private RideType rideType;

    public Ride(double distance, double time, RideType rideType) {
        this.rideType = rideType;
        this.distance = distance;
        this.time = time;
    }

    public RideType getRideType() {
        return rideType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
