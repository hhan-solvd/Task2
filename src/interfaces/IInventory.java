package interfaces;

import collections.LinkedList;
import vehicles.Vehicle;

import java.util.List;

public interface IInventory<T> {
    LinkedList<String> getInventory();

    void addVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);
}
