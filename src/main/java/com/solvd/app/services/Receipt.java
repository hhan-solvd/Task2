package com.solvd.app.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Receipt {
    private static final Logger LOGGER = LogManager.getLogger(Receipt.class);
    private Transaction transaction;

    public Receipt(Transaction trans) {
        transaction = trans;
    }

    public void printReceipt() {
        LOGGER.info("AAA Dealership Receipt");
        LOGGER.info("-----------------------------");
        LOGGER.info("Customer: " + transaction.getCustomerName());
        LOGGER.info("Employee: " + transaction.getEmployeeName());
        LOGGER.info("Vehicle: " + transaction.getVehicleModel() + " " +
                transaction.getVehicleYear() + " " + transaction.getVehicleColor());
        LOGGER.info("Price: " + transaction.getVehiclePrice());
        LOGGER.info("Payment type: " + transaction.getPaymentType());

        if (transaction.getLoanAmount() > 0) {
            LOGGER.info("Paid Amount: " + transaction.getCustomerBudget());
            LOGGER.info("Loan Amount: " + transaction.getLoanAmount());
        }
    }
}
