package com.solvd.app.people;

import com.solvd.app.interfaces.IPerson;
import com.solvd.app.vehicles.Vehicle;
import com.solvd.app.exceptions.EmptyStringException;
import com.solvd.app.exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.Objects;

public class Customer implements IPerson {
    ArrayList<Vehicle> purchasedVehicles = new ArrayList<>();
    private String name;
    private int phone;
    private double budget;

    public Customer(String customerName, int customerPhone, double customerBudget)
            throws EmptyStringException {
        if (customerName.isEmpty()) {
            throw new EmptyStringException("Customer's name can not be empty!");
        }

        if (customerPhone < 0) {
            throw new NegativeNumberException("Phone number must be a non-negative integer!");
        }

        if (customerBudget < 0) {
            throw new NegativeNumberException("Budget must be a non-negative number!");
        }

        name = customerName;
        phone = customerPhone;
        budget = customerBudget;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public double getBudget() {
        return budget;
    }

    public void setPurchasedVehicles(Vehicle vehicle) {
        purchasedVehicles.add(vehicle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getPhone() == customer.getPhone() &&
                Double.compare(customer.getBudget(), getBudget()) == 0 &&
                Objects.equals(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getBudget());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", budget=" + budget +
                '}';
    }
}
