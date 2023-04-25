package com.solvd.cardealership;

import java.util.Objects;

public class Customer {
    private String name;
    private int phone;
    private double budget;

    public Customer(String customerName, int customerPhone, double customerBudget) {
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
