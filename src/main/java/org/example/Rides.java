package org.example;

public class Rides {
    private double distance;
    private double time;
    private String type;
    public Rides(double distance,double time,String type) {
        this.distance=distance;
        this.time=time;
        this.type=type;
    }
    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public String getType() {
        return type;
    }
}
