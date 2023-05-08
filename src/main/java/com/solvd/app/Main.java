package com.solvd.app;

import com.solvd.app.datasetup.*;
import com.solvd.app.exceptions.EmptyStringException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.app.people.*;
import com.solvd.app.services.*;
import com.solvd.app.vehicles.*;

/**
 * The Main class instantiates objects of classes from people, services, collections and
 * vehicles package.
 */
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(final String... args) throws EmptyStringException {
        Manager manager = DataProvider.predefinedManagers()[0];

        Employee employee1 = DataProvider.predefinedEmployees()[0];
        Employee employee2 = DataProvider.predefinedEmployees()[1];

        Customer customer1 = DataProvider.predefinedCustomers()[0];
        Customer customer2 = DataProvider.predefinedCustomers()[1];
        Customer customer3 = DataProvider.predefinedCustomers()[2];

        Vehicle vehicle1 = DataProvider.predefinedVehicles()[0];
        Vehicle vehicle2 = DataProvider.predefinedVehicles()[1];
        Vehicle vehicle3 = DataProvider.predefinedVehicles()[2];

        Dealership dealership = new Dealership();
        VehicleInventory inventory = new VehicleInventory();

        // Manager adds employee to employee list
        manager.addEmployeeToList(employee1, dealership.getEmployeeList());
        manager.addEmployeeToList(employee2, dealership.getEmployeeList());

        // Employee adds vehicle to the inventory
        employee1.addVehicleToInventory(vehicle1, inventory);
        employee1.addVehicleToInventory(vehicle2, inventory);
        employee2.addVehicleToInventory(vehicle3, inventory);

        // Employee adds customer to the customer list
        employee1.addCustomerToList(customer1, dealership.getCustomerList());
        employee1.addCustomerToList(customer2, dealership.getCustomerList());
        employee2.addCustomerToList(customer3, dealership.getCustomerList());

        /*
         * Customer1 buys vehicle1 from employee1.
         */
        boolean result1 = employee1.checkVehicleAvailability(vehicle1, inventory);
        if (!result1) {
            LOGGER.info("-----------------------------");
            LOGGER.info("This vehicle is not available.");
        } else {
            // Check if this customer needs to finance to buy this vehicle
            Finance finance1 = new Finance(customer1, vehicle1);
            finance1.determinePaymentMethod();

            // Execute the transaction
            Transaction transaction1 = new Transaction(customer1, employee1, vehicle1, finance1);
            employee1.addTransactionToList(transaction1, dealership.getTransactionList());

            // Print the receipt
            Receipt receipt1 = new Receipt(transaction1);
            receipt1.printReceipt();

            // Employee adds this vehicle to customer's purchase history and removes it from the inventory
            employee1.addVehicleToCustomerPurchaseHistory(customer1, vehicle1);
            employee1.removeVehicleFromInventory(vehicle1, inventory);

            // Customer evaluates the service
            CustomerEvaluation evaluation1 = new CustomerEvaluation(employee1, DataProvider.predefinedRatings().get(4),
                    DataProvider.predefinedComments().get(0));
            evaluation1.calculateRating();
            evaluation1.addEvaluationToMap(dealership.getEvaluationMap());

            // Print the evaluation
            EvaluationSummary feedback1 = new EvaluationSummary(transaction1, evaluation1);
            feedback1.printFeedback();
        }

        /*
         * Customer2 buys to vehicle1 (this vehicle has been sold) from employee2.
         */
        boolean result2 = employee2.checkVehicleAvailability(vehicle1, inventory);
        if (!result2) {
            LOGGER.info("-----------------------------");
            LOGGER.info("This vehicle is not available.");
        } else {
            // Check if this customer needs to finance to buy this vehicle
            Finance finance2 = new Finance(customer2, vehicle1);
            finance2.determinePaymentMethod();

            // Execute the transaction
            Transaction transaction2 = new Transaction(customer2, employee2, vehicle1, finance2);
            employee2.addTransactionToList(transaction2, dealership.getTransactionList());

            // Print the receipt
            Receipt receipt2 = new Receipt(transaction2);
            receipt2.printReceipt();

            // Employee adds this vehicle to customer's purchase history and removes it from the inventory
            employee2.addVehicleToCustomerPurchaseHistory(customer2, vehicle1);
            employee2.removeVehicleFromInventory(vehicle1, inventory);

            // Customer evaluates the service
            CustomerEvaluation evaluation2 = new CustomerEvaluation(employee2, DataProvider.predefinedRatings().get(2),
                    DataProvider.predefinedComments().get(1));
            evaluation2.calculateRating();
            evaluation2.addEvaluationToMap(dealership.getEvaluationMap());

            // Print the evaluation
            EvaluationSummary feedback2 = new EvaluationSummary(transaction2, evaluation2);
            feedback2.printFeedback();
        }

        /*
         * Customer3 buys vehicle3 from employee2.
         */
        boolean result3 = employee2.checkVehicleAvailability(vehicle3, inventory);
        if (!result3) {
            LOGGER.info("-----------------------------");
            LOGGER.info("This vehicle is not available.");
        } else {
            // Check if this customer needs to finance to buy this vehicle
            Finance finance3 = new Finance(customer3, vehicle3);
            finance3.determinePaymentMethod();

            // Execute the transaction
            Transaction transaction3 = new Transaction(customer3, employee2, vehicle3, finance3);
            employee2.addTransactionToList(transaction3, dealership.getTransactionList());

            // Print the receipt
            Receipt receipt3 = new Receipt(transaction3);
            receipt3.printReceipt();

            // Employee adds this vehicle to customer's purchase history and removes it from the inventory
            employee2.addVehicleToCustomerPurchaseHistory(customer3, vehicle3);
            employee2.removeVehicleFromInventory(vehicle3, inventory);

            // Customer evaluates the service
            CustomerEvaluation evaluation3 = new CustomerEvaluation(employee2, DataProvider.predefinedRatings().get(4),
                    DataProvider.predefinedComments().get(2));
            evaluation3.calculateRating();
            evaluation3.addEvaluationToMap(dealership.getEvaluationMap());

            // Print the evaluation
            EvaluationSummary feedback3 = new EvaluationSummary(transaction3, evaluation3);
            feedback3.printFeedback();
        }

        // Print the collections
        VehicleInventory.printVehicleInventory();
        dealership.displayCustomers();
        dealership.displayEmployees();
        dealership.displayTransactions();
        dealership.displayEvaluations();
    }
}