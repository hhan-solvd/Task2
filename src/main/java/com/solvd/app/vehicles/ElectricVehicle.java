package com.solvd.app.vehicles;

import com.solvd.app.exceptions.EmptyStringException;
import com.solvd.app.exceptions.NegativeNumberException;

public class ElectricVehicle extends Vehicle {
    protected int batteryLife; // years of battery life

    public ElectricVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                           double vehiclePrice, int vehicleBatteryLife) throws EmptyStringException {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        if (vehicleBatteryLife < 0) {
            throw new NegativeNumberException("Battery's life must be a non-negative integer!");
        }

        batteryLife = vehicleBatteryLife;
    }

    @Override
    public String getOtherInfo() {
        return "ElectricVehicle{" +
                "batteryLife=" + batteryLife +
                '}';
    }
}
