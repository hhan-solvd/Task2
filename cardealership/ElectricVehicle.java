package com.solvd.cardealership;

public class ElectricVehicle extends Vehicle {
    private int batteryLife; // years of battery life

    public ElectricVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                           double vehiclePrice, int vehicleBatteryLife) {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        batteryLife = vehicleBatteryLife;
    }

    public int getBatteryLife() {
        return batteryLife;
    }
}
