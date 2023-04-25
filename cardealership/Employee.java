package com.solvd.cardealership;

import java.util.Objects;

public class Employee {
    private String name;
    private int id;
    private double overallRating = 0; // tbe employee's overall rating with 0 to 5
    private int ratingCounter = 0;    // times that the employee has been rated

    public Employee(String employeeName, int employeeId) {
        name = employeeName;
        id = employeeId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setRating(double employeeRating) {
        overallRating = employeeRating;
    }

    public double getRating() {
        return overallRating;
    }

    public void setCounter(int value) {
        ratingCounter = value;
    }

    public int getCounter() {
        return ratingCounter;
    }

    // Add vehicle to inventory
    public void addVehicleToInventory(Vehicle vehicle, VehicleInventory inventory) {
        if (!inventory.getInventory().contains(vehicle.toString())) {
            inventory.addVehicle(vehicle);
        }
    }

    // Check if the vehicle is available
    public boolean checkVehicleAvailability(Vehicle vehicle, VehicleInventory inventory) {
        if (inventory.getInventory().contains(vehicle.toString())) {
            return true;
        } else {
            return false;
        }
    }

    // Remove vehicle from inventory
    public void removeVehicleFromInventory(Vehicle vehicle, VehicleInventory inventory) {
        if (inventory.getInventory().contains(vehicle.toString())) {
            inventory.removeVehicle(vehicle);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getId() == employee.getId() &&
                Double.compare(employee.overallRating, overallRating) == 0 &&
                ratingCounter == employee.ratingCounter &&
                Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), overallRating, ratingCounter);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", overallRating=" + overallRating +
                ", ratingCounter=" + ratingCounter +
                '}';
    }
}
