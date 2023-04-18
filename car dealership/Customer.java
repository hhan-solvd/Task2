package com.solvd.cardealership;

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
}
