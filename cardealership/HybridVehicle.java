package com.solvd.cardealership;

public class HybridVehicle extends Vehicle {
    private boolean plugin; // if it is a plug-in hybrid vehicle

    public HybridVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                         double vehiclePrice, boolean value) {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        plugin = value;
    }

    public boolean getPlugin() {
        return plugin;
    }
}
