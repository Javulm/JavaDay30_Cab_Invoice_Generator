package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    private final double totalFare;
    private final int totalRides;
    private final double averageFare;

    public Invoice(double totalFare,int totalRides, double averageFare) {
        this.totalFare = totalFare;
        this.totalRides = totalRides;
        this.averageFare = averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.averageFare, averageFare) == 0 && totalRides == invoice.totalRides && Double.compare(invoice.totalFare, totalFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageFare, totalRides, totalFare);
    }
}
