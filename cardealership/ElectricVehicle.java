package com.solvd.cardealership;

public class ElectricVehicle extends Vehicle {
    protected int batteryLife; // years of battery life

    public ElectricVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                           double vehiclePrice, int vehicleBatteryLife) {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        batteryLife = vehicleBatteryLife;
    }

    @Override
    public String getOtherInfo() {
        return "ElectricVehicle{" +
                "batteryLife=" + batteryLife +
                '}';
    }
}
