package com.solvd.cardealership;

public class Finance {
    private Customer customer;
    private Vehicle vehicle;
    private boolean needFinance = false; // if the customer needs to finance
    private double loanAmount = 0;

    public Finance(Customer buyer, Vehicle vehicleToBuy) {
        customer = buyer;
        vehicle = vehicleToBuy;
    }

    public boolean getFianceStatus() {
        return needFinance;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    // Check if a customer needs to finance
    public void financeOrNot() {
        if (customer.getBudget() < vehicle.getPrice()) {
            needFinance = true;
            loanAmount = vehicle.getPrice() - customer.getBudget();
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
