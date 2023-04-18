package com.solvd.cardealership;

public class GasVehicle extends Vehicle {
    private double range;

    public GasVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                      double vehiclePrice, double vehicleRange) {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        range = vehicleRange;
    }

    public double getRange() {
        return range;
    }
}
