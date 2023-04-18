package com.solvd.cardealership;

/**
 * The ServiceFeedback class prints the summary of the customer's evaluation.
 */
public class EvaluationSummary {
    private Transaction transaction;
    private CustomerEvaluation customerEvaluation;

    public EvaluationSummary(Transaction trans, CustomerEvaluation evaluation) {
        transaction = trans;
        customerEvaluation = evaluation;
    }

    public void printFeedback() {
        System.out.println();
        System.out.println("Service Feedback");
        System.out.println("-----------------------------");
        System.out.println("Customer: " + transaction.getCustomerName());
        System.out.println("Customer Phone: " + transaction.getCustomerPhone());
        System.out.println("Employee: " + transaction.getEmployeeName());
        System.out.println("Employee ID: " + transaction.getEmployeeId());
        System.out.println("Service rating (0-5): " + customerEvaluation.getRating());
        System.out.println("Comments: " + customerEvaluation.getComment());
        System.out.println("Employee overall rating: " + transaction.getEmployeeRating());
    }
}
