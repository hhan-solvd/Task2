package people;

import interfaces.IPerson;
import vehicles.Vehicle;
import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.Objects;

public class Customer implements IPerson {
    private String name;
    private int phone;
    private double budget;
    ArrayList<Vehicle> purchasedVehicles = new ArrayList<>();

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
