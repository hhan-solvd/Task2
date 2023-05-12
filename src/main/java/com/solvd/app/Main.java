package com.solvd.app;

import com.solvd.app.datasetup.*;
import com.solvd.app.enums.*;
import com.solvd.app.exceptions.EmptyStringException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.app.people.*;
import com.solvd.app.services.*;
import com.solvd.app.vehicles.*;
import com.solvd.app.uniquewordscalculator.UniqueWordsCalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The Main class instantiates objects of classes from people, services, collections and
 * vehicles package.
 */
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(final String... args) throws EmptyStringException, IOException {
        Manager manager = DataProvider.predefinedManagers()[0];
        manager.setEmployeeTitle(EmployeeTitle.MANAGER);
        manager.setEmployeeType(EmployeeType.FULL_TIME);

        Employee employee1 = DataProvider.predefinedEmployees()[0];
        Employee employee2 = DataProvider.predefinedEmployees()[1];
        employee1.setEmployeeTitle(EmployeeTitle.SALESPERSON);
        employee2.setEmployeeTitle(EmployeeTitle.SALESPERSON);
        employee1.setEmployeeType(EmployeeType.PART_TIME);
        employee2.setEmployeeType(EmployeeType.CONTRACTOR);


        Customer customer1 = DataProvider.predefinedCustomers()[0];
        Customer customer2 = DataProvider.predefinedCustomers()[1];
        Customer customer3 = DataProvider.predefinedCustomers()[2];
        customer1.setCustomerType(CustomerType.REGULAR);
        customer2.setCustomerType(CustomerType.VIP);
        customer3.setCustomerType(CustomerType.REGULAR);

        Vehicle vehicle1 = DataProvider.predefinedVehicles()[0];
        Vehicle vehicle2 = DataProvider.predefinedVehicles()[1];
        Vehicle vehicle3 = DataProvider.predefinedVehicles()[2];
        vehicle1.setVehicleBodyStyle(VehicleBodyStyle.SUV);
        vehicle2.setVehicleBodyStyle(VehicleBodyStyle.SUV);
        vehicle3.setVehicleBodyStyle(VehicleBodyStyle.SEDAN);
        vehicle1.setVehicleCategory(VehicleCategory.ELECTRIC);
        vehicle2.setVehicleCategory(VehicleCategory.HYBRID);
        vehicle3.setVehicleCategory(VehicleCategory.GASOLINE);

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

        /*
         * Calculate unique words in a file
         */
        UniqueWordsCalculator.addContentsToFile(vehicle1.toString());
        UniqueWordsCalculator.calculateUniqueWords("src/main/resources/input.txt");

        /*
         * Usage of Lambda functions
         */
        LOGGER.info("-------------Usage of Lambda functions----------------");
        // Get customers with a budget that is at least 10000.
        // An example of using Lambda function - Predicate
        ArrayList<Customer> filteredCustomers = dealership.filterWithPredicate(customer ->
                customer.getBudget() >= 10000, dealership.getCustomerList());
        dealership.printList(LOGGER::info, filteredCustomers);

        // Get employees with at least 4 stars reviews.
        // An example of using Lambda function - Predicate
        ArrayList<Employee> filteredEmployees = dealership.filterWithPredicate(employee -> employee.getRating() >= 4,
                dealership.getEmployeeList());
        dealership.printList(LOGGER::info, filteredEmployees);

        // Compare a customer's budget with a vehicle's price.
        // An example of using custom generic Lambda function - IComparison
        String result = dealership.compareWithCustomFunction((customerBudget, carPrice) -> {
            if (customerBudget >= carPrice) {
                return "This customer has enough cash for this vehicle.";
            } else {
                return "This customer does not have enough cash for this vehicle.";
            }
        }, customer1.getBudget(), vehicle1.getPrice());
        LOGGER.info(result);

        // Get the transactions made by employee1.
        // An example of using Lambda function - BiPredicate
        ArrayList<Transaction> filteredTransactions = dealership.filterWithBiPredicate((transaction, employee) ->
                        Objects.equals(transaction.getEmployeeName(), employee.getName()), dealership.getTransactionList(),
                employee1);

        // Print a list
        // An example of using Lambda function - Consumer
        dealership.printList(LOGGER::info, filteredTransactions);

        // Get the number of vehicles that each customer has purchased.
        // An example of using Lambda function - Function
        ArrayList<String> customers = dealership.getStringList((customer -> customer.getName() +
                " bought " + customer.getPurchasedVehicles().size() + " vehicles."), dealership.getCustomerList());
        dealership.printList(LOGGER::info, customers);

        // Get transactions with employee1 as salesperson and customer1 as the customer.
        // An example of using custom generic Lambda function - IFilter
        ArrayList<Transaction> filteredList = dealership.filterWithCustomFunction((transaction, employee, customer) ->
                        Objects.equals(transaction.getEmployeeName(), employee.getName()) &&
                                Objects.equals(transaction.getCustomerName(), customer.getName())
                , dealership.getTransactionList(), employee1, customer1);
        dealership.printList(LOGGER::info, filteredList);

        // Print info.
        // An example of using custom generic Lambda function - IPrintInfo
        dealership.printWithCustomFunction((vehicle, employee, customer) -> LOGGER.info("A " + vehicle.getModel() +
                " " + vehicle.getYear() + " has been sold to " + customer.getName() + " by " +
                employee.getName() + "!"), vehicle1, employee1, customer1);

        // Print congrats message to employee1 who sold vehicle1.
        // An example of using Lambda function - BiConsumer
        dealership.printMessage((vehicle, employee) -> LOGGER.info("Congratulations! " + employee.getName() +
                " has sold a " + vehicle.getModel() + " " + vehicle.getYear() + "!"), vehicle1, employee1);

        /*
         * Usage of enums
         */
        LOGGER.info("-------------Usage of enums----------------");
        LOGGER.info(customer1.getName() + " is a " + customer1.getCustomerType().getType() + ".");
        LOGGER.info(employee1.getName() + " is a " + employee1.getEmployeeTitle().getJobTitle() +
                " with a salary of " + employee1.getEmployeeTitle().getSalary() + " who is a " +
                employee1.getEmployeeType().getType() + " employee and works " +
                employee1.getEmployeeType().getHours() + " hours a week.");
        LOGGER.info(vehicle2.getModel() + " is a " + vehicle2.getVehicleCategory().getCategory() +
                " which is a " + vehicle2.getVehicleBodyStyle().getStyle() + " with " +
                vehicle2.getVehicleBodyStyle().getSeats() + " seats.");
    }
}
