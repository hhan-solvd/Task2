package com.solvd.cardealership;

/**
 * The Dealership class instantiates objects of classes from com.solvd.cardealership package.
 */
public class Dealership {
    public static void main(String[] args) {
        VehicleInventory inventory = new VehicleInventory();
        Employee employee1 = new Employee("Lucy", 678);
        Employee employee2 = new Employee("Alan", 345);

        Customer customer1 = new Customer("Jack", 123456,
                2000);
        Customer customer2 = new Customer("Kathy", 789012,
                30000);
        Customer customer3 = new Customer("Hannah", 654321,
                16000);

        ElectricVehicle vehicle1 = new ElectricVehicle("Chevy Bolt", "grey",
                2019, 20000, 20);
        HybridVehicle vehicle2 = new HybridVehicle("Toyota RAV4", "red",
                2023, 30000, true);
        GasVehicle vehicle3 = new GasVehicle("Nissan Sentra", "blue",
                2022, 22000, 118);

        // Employee adds vehicle to the inventory
        employee1.addVehicleToInventory(vehicle1, inventory);
        employee1.addVehicleToInventory(vehicle2, inventory);
        employee2.addVehicleToInventory(vehicle3, inventory);

        /*
         * Customer1 buys vehicle1 from employee1.
         */
        boolean result1 = employee1.checkVehicleAvailability(vehicle1, inventory);
        if (!result1) {
            System.out.println("-----------------------------");
            System.out.println("This vehicle is not available.");
        } else {
            // Check if this customer needs to finance to buy this vehicle
            Finance finance1 = new Finance(customer1, vehicle1);
            finance1.financeOrNot();

            // Execute the transaction
            Transaction transaction1 = new Transaction(customer1, employee1, vehicle1, finance1);
            transaction1.determinePaymentMethod();

            // Print the receipt
            Receipt receipt1 = new Receipt(transaction1);
            receipt1.printReceipt();

            // Employee removes this vehicle from the inventory
            employee1.removeVehicleFromInventory(vehicle1, inventory);

            // Customer evaluates the service
            CustomerEvaluation evaluation1 = new CustomerEvaluation(employee1, 5,
                    "Excellent service!");
            evaluation1.calculateRating();

            // Print the evaluation
            EvaluationSummary feedback1 = new EvaluationSummary(transaction1, evaluation1);
            feedback1.printFeedback();
        }

        /*
         * Customer2 buys to vehicle1 (this vehicle has been sold) from employee2.
         */
        boolean result2 = employee2.checkVehicleAvailability(vehicle1, inventory);
        if (!result2) {
            System.out.println("-----------------------------");
            System.out.println("This vehicle is not available.");
        } else {
            // Check if this customer needs to finance to buy this vehicle
            Finance finance2 = new Finance(customer2, vehicle1);
            finance2.financeOrNot();

            // Execute the transaction
            Transaction transaction2 = new Transaction(customer2, employee2, vehicle1, finance2);
            transaction2.determinePaymentMethod();

            // Print the receipt
            Receipt receipt2 = new Receipt(transaction2);
            receipt2.printReceipt();

            // Employee removes this vehicle from the inventory
            employee2.removeVehicleFromInventory(vehicle1, inventory);

            // Customer evaluates the service
            CustomerEvaluation evaluation2 = new CustomerEvaluation(employee2, 3,
                    "Can be better!");
            evaluation2.calculateRating();

            // Print the evaluation
            EvaluationSummary feedback2 = new EvaluationSummary(transaction2, evaluation2);
            feedback2.printFeedback();
        }

        /*
         * Customer3 buys vehicle3 from employee2.
         */
        boolean result3 = employee2.checkVehicleAvailability(vehicle3, inventory);
        if (!result3) {
            System.out.println("-----------------------------");
            System.out.println("This vehicle is not available.");
        } else {
            // Check if this customer needs to finance to buy this vehicle
            Finance finance3 = new Finance(customer3, vehicle3);
            finance3.financeOrNot();

            // Execute the transaction
            Transaction transaction3 = new Transaction(customer3, employee2, vehicle3, finance3);
            transaction3.determinePaymentMethod();

            // Print the receipt
            Receipt receipt3 = new Receipt(transaction3);
            receipt3.printReceipt();

            // Employee removes this vehicle from the inventory
            employee2.removeVehicleFromInventory(vehicle3, inventory);

            // Customer evaluates the service
            CustomerEvaluation evaluation3 = new CustomerEvaluation(employee2, 5,
                    "Great service!");
            evaluation3.calculateRating();

            // Print the evaluation
            EvaluationSummary feedback3 = new EvaluationSummary(transaction3, evaluation3);
            feedback3.printFeedback();
        }
    }
}
