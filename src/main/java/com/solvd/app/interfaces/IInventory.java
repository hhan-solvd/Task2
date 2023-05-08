package com.solvd.app.interfaces;

import com.solvd.app.collections.LinkedList;
import com.solvd.app.vehicles.Vehicle;

public interface IInventory {
    LinkedList<String> getInventory();

    void addVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);
}
