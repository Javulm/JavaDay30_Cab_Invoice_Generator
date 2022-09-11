package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare(){
        double totalFare = CabInvoiceGenerator.calculateFare(5.0,5);
        Assertions.assertEquals(55,totalFare);
    }
    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare(){
        double totalFare = CabInvoiceGenerator.calculateFare(0.1,2);
        Assertions.assertEquals(5.0,totalFare);
    }
    @Test
    public void givenMultipleRideShouldReturnAggregateFare(){
        Ride[] rides = { new Ride(20,5), new Ride(10, 5),new Ride(0.2, 3)};
        double totalFare = CabInvoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(315.0, totalFare);
    }
    @Test
    public void giveMultipleRideShouldReturnInvoice(){
        Ride[] rides = { new Ride(20,5), new Ride(10, 5),new Ride(0.2, 2)};
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(315, 3, 105);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    public void giveUserIdShouldReturnInvoice(){
        Ride[] ride1 = { new Ride(20,6), new Ride(10, 5),new Ride(0.3, 1)};
        Ride[] ride2 = { new Ride(10,4), new Ride(20, 3),new Ride(0.2, 2)};
        RideRepository.customerList.add(new Customer(1,ride1));
        RideRepository.customerList.add(new Customer(2,ride2));
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(312.0, 3, 104);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

}
