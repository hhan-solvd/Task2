package com.solvd.cardealership;

public class Receipt {
    private Transaction transaction;

    public Receipt(Transaction trans) {
        transaction = trans;
    }

    public void printReceipt() {
        System.out.println();
        System.out.println("AAA Dealership Receipt");
        System.out.println("-----------------------------");
        System.out.println("Customer: " + transaction.getCustomerName());
        System.out.println("Employee: " + transaction.getEmployeeName());
        System.out.println("Vehicle: " + transaction.getVehicleModel() + " " +
                transaction.getVehicleYear() + " " + transaction.getVehicleColor());
        System.out.println("Price: " + transaction.getVehiclePrice());
        System.out.println("Payment type: " + transaction.getPaymentType());

        if (transaction.getLoanAmount() > 0) {
            System.out.println("Paid Amount: " + transaction.getCustomerBudget());
            System.out.println("Loan Amount: " + transaction.getLoanAmount());
        }
    }
}
