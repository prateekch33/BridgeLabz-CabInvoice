package org.example;

import java.util.ArrayList;
import java.util.List;

public class CabInvoice {
    static final double COST_PER_KM=10;
    static final double PREMIUM_COST_PER_KM=15;
    static final double COST_PER_MIN=1;
    static final double PREMIUM_COST_PER_MIN=1;
    static final double MIN_COST=5;
    static final double PREMIUM_MIN_COST=5;
    public double calculateFare(double dist, double time,String type) {
        double totalFare;
        if(type.compareTo("Normal")==0) {
            totalFare = dist * COST_PER_KM + time * COST_PER_MIN;
            return Math.max(totalFare, MIN_COST);
        } else {
            totalFare = dist * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MIN;
            return Math.max(totalFare, PREMIUM_MIN_COST);
        }
    }

    public double calculateTotalFare(List<Rides> multipleRides) {
        CabInvoice ob=new CabInvoice();
        double totalFare=0.0;
        for(Rides i:multipleRides){
            totalFare+=ob.calculateFare(i.getDistance(),i.getTime(),i.getType());
        }
        return totalFare;
    }

    public int countRides(List<Rides> multipleRides) {
        return multipleRides.size();
    }

    public double averageFare(List<Rides> multipleRides) {
        double totalFare=calculateTotalFare(multipleRides);
        int totalRides=countRides(multipleRides);
        double average=totalFare/totalRides;
        return average;
    }
}
