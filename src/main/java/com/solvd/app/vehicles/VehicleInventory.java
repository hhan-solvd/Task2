package com.solvd.app.vehicles;

import com.solvd.app.interfaces.IInventory;
import com.solvd.app.exceptions.DuplicateVehicleException;
import com.solvd.app.exceptions.VehicleNotFoundException;
import com.solvd.app.collections.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VehicleInventory implements IInventory {
    private static final Logger LOGGER = LogManager.getLogger(VehicleInventory.class);

    protected static LinkedList<String> inventory;

    static {
        inventory = new LinkedList<>();
    }

    public LinkedList<String> getInventory() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        if (!inventory.findNode(vehicle.toString())) {
            inventory.addNode(vehicle.toString());
        } else {
            throw new DuplicateVehicleException(vehicle + " has already been in inventory!");
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        if (inventory.findNode(vehicle.toString())) {
            inventory.removeNode(vehicle.toString());
        } else {
            throw new VehicleNotFoundException(vehicle + " is not found in inventory!");
        }
    }

    public static void printVehicleInventory() {
        LOGGER.info("-------------Vehicle List----------------");
        LOGGER.info("Total number of vehicles: " + inventory.getSize());
        inventory.show();
    }
}
