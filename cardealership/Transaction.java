package com.solvd.cardealership;

public class Transaction {
    private Customer customer;
    private Employee employee;
    private Vehicle vehicle;
    private Finance finance;
    private String paymentType;

    public Transaction(Customer buyer, Employee staff, Vehicle car, Finance loan) {
        customer = buyer;
        employee = staff;
        vehicle = car;
        finance = loan;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerPhone() {
        return customer.getPhone();
    }

    public String getEmployeeName() {
        return employee.getName();
    }

    public int getEmployeeId() {
        return employee.getId();
    }

    public double getEmployeeRating() {
        return employee.getRating();
    }

    public String getVehicleModel() {
        return vehicle.getModel();
    }

    public String getVehicleColor() {
        return vehicle.getColor();
    }

    public int getVehicleYear() {
        return vehicle.getYear();
    }

    public double getVehiclePrice() {
        return vehicle.getPrice();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public double getLoanAmount() {
        return finance.getLoanAmount();
    }

    public double getCustomerBudget() {
        return customer.getBudget();
    }

    public void determinePaymentMethod() {
        if (finance.getFianceStatus()) {
            paymentType = "Finance";
        } else {
            paymentType = "Pay in Full";
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customer=" + customer +
                ", employee=" + employee +
                ", vehicle=" + vehicle +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
