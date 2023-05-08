package com.solvd.app.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The ServiceFeedback class prints the summary of the customer's evaluation.
 */
public final class EvaluationSummary {
    private static final Logger LOGGER = LogManager.getLogger(EvaluationSummary.class);
    private Transaction transaction;
    private CustomerEvaluation customerEvaluation;

    public EvaluationSummary(Transaction trans, CustomerEvaluation evaluation) {
        transaction = trans;
        customerEvaluation = evaluation;
    }

    public void printFeedback() {
        LOGGER.info("Service Feedback");
        LOGGER.info("-----------------------------");
        LOGGER.info("Customer: " + transaction.getCustomerName());
        LOGGER.info("Customer Phone: " + transaction.getCustomerPhone());
        LOGGER.info("Employee: " + transaction.getEmployeeName());
        LOGGER.info("Employee ID: " + transaction.getEmployeeId());
        LOGGER.info("Service rating (0-5): " + customerEvaluation.getRating());
        LOGGER.info("Comments: " + customerEvaluation.getComment());
        LOGGER.info("Employee overall rating: " + transaction.getEmployeeRating());
    }
}
