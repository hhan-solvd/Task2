package com.solvd.app.services;

import com.solvd.app.interfaces.IPaymentMethod;
import com.solvd.app.people.Customer;
import com.solvd.app.vehicles.Vehicle;

public class Finance implements IPaymentMethod {
    private Customer customer;
    private Vehicle vehicle;
    private String paymentMethod;
    private boolean needFinance = false; // if the customer needs to finance
    private double loanAmount = 0;

    public Finance(Customer buyer, Vehicle vehicleToBuy) {
        customer = buyer;
        vehicle = vehicleToBuy;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    // Check if a customer needs to finance
    public void determinePaymentMethod() {
        if (customer.getBudget() < vehicle.getPrice()) {
            paymentMethod = "Finance";
            needFinance = true;
            loanAmount = vehicle.getPrice() - customer.getBudget();
        } else {
            paymentMethod = "Pay in Full";
        }
    }

    @Override
    public String toString() {
        return "Finance{" +
                "needFinance=" + needFinance +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
