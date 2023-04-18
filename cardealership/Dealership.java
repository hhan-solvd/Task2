package com.solvd.cardealership;

/**
 * The Dealership class instantiates objects of classes from com.solvd.cardealership package.
 */
public class Dealership {
    public static void main(String[] args) {

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

        Employee employee1 = new Employee("Lucy", 678);
        Employee employee2 = new Employee("Alan", 345);

        /*
         * Customer1 buys vehicle1 from employee1.
         */
        Finance finance1 = new Finance(customer1, vehicle1);
        finance1.financeOrNot();

        Transaction transaction1 = new Transaction(customer1, employee1, vehicle1, finance1);
        transaction1.payMethod();

        Receipt receipt1 = new Receipt(transaction1);
        receipt1.printReceipt();

        CustomerEvaluation evaluation1 = new CustomerEvaluation(employee1, 5,
                "Excellent service!");
        evaluation1.calculateRating();

        EvaluationSummary feedback1 = new EvaluationSummary(transaction1, evaluation1);
        feedback1.printFeedback();

        /*
         * Customer2 buys vehicle2 from employee2.
         */
        Finance finance2 = new Finance(customer2, vehicle2);
        finance2.financeOrNot();

        Transaction transaction2 = new Transaction(customer2, employee2, vehicle2, finance2);
        transaction2.payMethod();

        Receipt receipt2 = new Receipt(transaction2);
        receipt2.printReceipt();

        CustomerEvaluation evaluation2 = new CustomerEvaluation(employee2, 3,
                "Can be better!");
        evaluation2.calculateRating();

        EvaluationSummary feedback2 = new EvaluationSummary(transaction2, evaluation2);
        feedback2.printFeedback();

        /*
         * Customer3 buys vehicle3 from employee2.
         */
        Finance finance3 = new Finance(customer3, vehicle3);
        finance3.financeOrNot();

        Transaction transaction3 = new Transaction(customer3, employee2, vehicle3, finance3);
        transaction3.payMethod();

        Receipt receipt3 = new Receipt(transaction3);
        receipt3.printReceipt();

        CustomerEvaluation evaluation3 = new CustomerEvaluation(employee2, 5,
                "Great service!");
        evaluation3.calculateRating();

        EvaluationSummary feedback3 = new EvaluationSummary(transaction3, evaluation3);
        feedback3.printFeedback();
    }
}
