package com.solvd.cardealership;

import java.util.List;

public interface IInventory {
    List<String> getInventory();

    void addVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);
}
