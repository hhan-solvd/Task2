package com.solvd.cardealership;

public interface Worker {
    // Add vehicle to inventory
    void addVehicleToInventory(Vehicle vehicle, VehicleInventory inventory);

    // Check if the vehicle is available
    boolean checkVehicleAvailability(Vehicle vehicle, VehicleInventory inventory);

    // Remove vehicle from inventory
    void removeVehicleFromInventory(Vehicle vehicle, VehicleInventory inventory);
}
