package com.solvd.cardealership;

public class CustomerEvaluation implements IEvaluation {
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

        employee.setRating(newRating);
        employee.setCounter(newCounter);
    }
}
