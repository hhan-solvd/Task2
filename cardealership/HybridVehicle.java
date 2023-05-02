package com.solvd.cardealership;

public class HybridVehicle extends Vehicle {
    protected boolean plugin; // if it is a plug-in hybrid vehicle

    public HybridVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                         double vehiclePrice, boolean value) throws EmptyStringException {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        plugin = value;
    }

    @Override
    public String getOtherInfo() {
        return "HybridVehicle{" +
                "plugin=" + plugin +
                '}';
    }
}
