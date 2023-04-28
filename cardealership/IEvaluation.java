package com.solvd.cardealership;

public interface IEvaluation {
    int getRating();

    String getComment();

    void calculateRating(); // Calculates the overall rating for an employee
}
