package org.example;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
    String userId;
    List<Rides> multipleRides;

    public RideRepository(String userId) {
        this.userId=userId;
        this.multipleRides=new ArrayList<>();
    }
    public void addMultipleRides() {
        Rides ride1=new Rides(5,10,"Normal");
        multipleRides.add(ride1);
        Rides ride2=new Rides(2,5,"Premium");
        multipleRides.add(ride2);
        Rides ride3=new Rides(10,5,"Normal");
        multipleRides.add(ride3);
    }
    public List<Rides> listOfRides() {
        return multipleRides;
    }
}
