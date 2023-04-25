package com.solvd.cardealership;

public class GasVehicle extends Vehicle {
    protected double range;

    public GasVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                      double vehiclePrice, double vehicleRange) {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        range = vehicleRange;
    }

    @Override
    public String getOtherInfo() {
        return "GasVehicle{" +
                "range=" + range +
                '}';
    }
}
