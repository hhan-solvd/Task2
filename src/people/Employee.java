package people;

import interfaces.IPerson;
import interfaces.IWorker;
import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;
import exceptions.DuplicateVehicleException;
import exceptions.VehicleNotFoundException;
import vehicles.Vehicle;
import vehicles.VehicleInventory;
import services.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Employee implements IPerson, IWorker {
    private static final Logger LOGGER = LogManager.getLogger(Employee.class);
    private String name;
    private int id;
    private double overallRating = 0; // tbe employee's overall rating with 0 to 5
    private int ratingCounter = 0;    // times that the employee has been rated

    public Employee(String employeeName, int employeeId) throws EmptyStringException {
        if (employeeName.isEmpty()) {
            throw new EmptyStringException("Employee's name can not be empty!");
        }

        if (employeeId < 0) {
            throw new NegativeNumberException("employee ID must be a non-negative integer!");
        }

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
        if (employeeRating >= 0) {
            overallRating = employeeRating;
        } else {
            throw new NegativeNumberException("Rating can not be a negative number!");
        }
    }

    public double getRating() {
        return overallRating;
    }

    public void setCounter(int value) {
        if (ratingCounter >= 0) {
            ratingCounter = value;
        } else {
            throw new NegativeNumberException("Rating counter can not be a negative integer!");
        }
    }

    public int getCounter() {
        return ratingCounter;
    }

    // Add vehicle to inventory
    public void addVehicleToInventory(Vehicle vehicle, VehicleInventory inventory) {
        try {
            inventory.addVehicle(vehicle);
        } catch (DuplicateVehicleException e) {
            LOGGER.warn(vehicle.toString() + " has already been in inventory!");
        }
    }

    // Check if the vehicle is available
    public boolean checkVehicleAvailability(Vehicle vehicle, VehicleInventory inventory) {
        return inventory.getInventory().findNode(vehicle.toString());
    }

    // Remove vehicle from inventory
    public void removeVehicleFromInventory(Vehicle vehicle, VehicleInventory inventory) {
        try {
            inventory.removeVehicle(vehicle);
        } catch (VehicleNotFoundException e) {
            LOGGER.warn(vehicle.toString() + " is not found in inventory!");
        }
    }

    public void addCustomerToList(Customer customer, ArrayList<String> customerList) {
        customerList.add(customer.toString());
    }

    public void addTransactionToList(Transaction transaction, ArrayList<String> transactionList) {
        transactionList.add(transaction.toString());
    }

    public void addVehicleToCustomerPurchaseHistory(Customer customer, Vehicle vehicle) {
        customer.setPurchasedVehicles(vehicle);
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
