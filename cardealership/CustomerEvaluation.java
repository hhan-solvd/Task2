package com.solvd.cardealership;

public class CustomerEvaluation {
    private Employee employee;
    private int rating;      // Customer's rating to employee with integer 0 to 5
    private String comment;  // Customer's comments about the service

    public CustomerEvaluation(Employee emp, int customerRating,
                              String customerComment) {
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
    public void calculateRating() {
        double currentRating = employee.getRating();
        int counter = employee.getCounter();
        int newCounter = counter + 1;
        double newRating = 0;

        if (newCounter != 0) {
            newRating = (currentRating * counter + rating) / newCounter;
        }

        employee.setRating(newRating);
        employee.setCounter(newCounter);
    }
}
