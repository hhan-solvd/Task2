package com.solvd.cardealership;

public interface Evaluation {
    int getRating();

    String getComment();

    void calculateRating(); // Calculates the overall rating for an employee
}
