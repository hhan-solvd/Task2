package services;

import interfaces.IEvaluation;
import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;
import exceptions.DivisionByZeroException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Employee;
import collections.EvaluationMap;

public class CustomerEvaluation implements IEvaluation {
    private static final Logger LOGGER = LogManager.getLogger(Employee.class);
    private Employee employee;
    private int rating;      // Customer's rating to employee with integer 0 to 5
    private String comment;  // Customer's comments about the service

    public CustomerEvaluation(Employee emp, int customerRating,
                              String customerComment) throws EmptyStringException {
        if (customerRating < 0) {
            throw new NegativeNumberException("Rating must be a non-negative integer!");
        }

        if (customerComment.isEmpty()) {
            throw new EmptyStringException("Comment can not be empty!");
        }
        employee = emp;
        rating = customerRating;
        comment = customerComment;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    // Calculates the overall rating for an employee
    public final void calculateRating() {
        double currentRating = employee.getRating();
        int counter = employee.getCounter();
        int newCounter = counter + 1;
        double newRating;

        if (newCounter != 0) {
            newRating = (currentRating * counter + rating) / newCounter;
        } else {
            throw new DivisionByZeroException("Denominator can not be zero!");
        }

        try {
            employee.setRating(newRating);
        } catch (NegativeNumberException e) {
            LOGGER.warn("New rating can not be a negative number!");
        }

        try {
            employee.setCounter(newCounter);
        } catch (NegativeNumberException e) {
            LOGGER.warn("New rating counter can not be a negative integer!");
        }
    }

    public void addEvaluationToMap(EvaluationMap evaluationList) {
        evaluationList.addEvaluation(employee.getId(), toString());
    }

    @Override
    public String toString() {
        return "employeeName=" + employee.getName() +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}