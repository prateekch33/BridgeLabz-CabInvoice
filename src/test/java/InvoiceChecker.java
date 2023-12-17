import org.example.CabInvoice;
import org.example.RideRepository;
import org.example.Rides;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceChecker {
    @Test
    void checkFare() {
        CabInvoice ob=new CabInvoice();
        double calculateTotalFare=ob.calculateFare(5,10,"Normal");
        assertEquals(60,calculateTotalFare);
    }
    @Test
    void minFare() {
        CabInvoice ob=new CabInvoice();
        double minTotalFare=ob.calculateFare(0,2,"Normal");
        assertEquals(5,minTotalFare);
    }
    @Test
    void multipleRides() {
        CabInvoice ob=new CabInvoice();
        String userId="1";
        RideRepository ob1=new RideRepository(userId);
        ob1.addMultipleRides();
        double totalFare=ob.calculateTotalFare(ob1.listOfRides());
        assertEquals(190,totalFare);
    }
    @Test
    void checkInvoice() {
        CabInvoice ob=new CabInvoice();
        String userId="1";
        RideRepository ob1=new RideRepository(userId);
        ob1.addMultipleRides();
        assertEquals(3,ob.countRides(ob1.listOfRides()));
        assertEquals(190,ob.calculateTotalFare(ob1.listOfRides()));
        assertEquals(63.333333333333336,ob.averageFare(ob1.listOfRides()));
    }
    @Test
    void checkInvoices() {
        CabInvoice ob=new CabInvoice();
        HashMap<String,RideRepository> userRides=new HashMap<>();
        String[] userIds={"1","2","3"};
        RideRepository ob1=new RideRepository(userIds[0]);
        ob1.addMultipleRides();
        RideRepository ob2=new RideRepository(userIds[0]);
        ob2.addMultipleRides();
        RideRepository ob3=new RideRepository(userIds[0]);
        ob3.addMultipleRides();
        userRides.put(userIds[0],ob1);
        userRides.put(userIds[1],ob2);
        userRides.put(userIds[2],ob3);
        RideRepository expectedUser=userRides.get("2");
        List<Rides> rides=expectedUser.listOfRides();
        Double[] cost = {60.0,35.0,105.0};
        for(int i=0;i<rides.size();i++) {
            assertEquals(cost[i],ob.calculateFare(rides.get(i).getDistance(),rides.get(i).getTime(),rides.get(i).getType()));
        }

    }
}
