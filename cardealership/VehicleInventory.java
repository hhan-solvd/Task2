package com.solvd.cardealership;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class VehicleInventory implements IInventory {
    private static final Logger LOGGER = LogManager.getLogger(VehicleInventory.class);
    protected static ArrayList<String> inventory;

    static {
        inventory = new ArrayList<>();
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        if (!inventory.contains(vehicle.toString())) {
            inventory.add(vehicle.toString());
        } else {
            throw new DuplicateVehicleException(vehicle + " has already been in inventory!");
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        if (inventory.contains(vehicle.toString())) {
            inventory.remove(vehicle.toString());
        } else {
            throw new VehicleNotFoundException(vehicle + " is not found in inventory!");
        }
    }

    public static void printVehicleInventory() {
        for (String vehicle : inventory) {
            LOGGER.info(vehicle);
        }
    }
}
