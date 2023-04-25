package com.solvd.cardealership;

import java.util.*;

public class VehicleInventory implements Inventory {
    protected static ArrayList<String> inventory = new ArrayList<>();

    public List<String> getInventory() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle.toString());
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle.toString());
    }
}
