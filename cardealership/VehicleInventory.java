package com.solvd.cardealership;

import java.util.*;

public class VehicleInventory {
    protected static List<Object> inventory = new ArrayList<>();

    public VehicleInventory() {
    }

    public List<Object> getInventory() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
