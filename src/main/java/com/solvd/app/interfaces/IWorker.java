package com.solvd.app.interfaces;

import com.solvd.app.vehicles.Vehicle;
import com.solvd.app.vehicles.VehicleInventory;

public interface IWorker {
    // Add vehicle to inventory
    void addVehicleToInventory(Vehicle vehicle, VehicleInventory inventory);

    // Check if the vehicle is available
    boolean checkVehicleAvailability(Vehicle vehicle, VehicleInventory inventory);

    // Remove vehicle from inventory
    void removeVehicleFromInventory(Vehicle vehicle, VehicleInventory inventory);
}
