package com.solvd.cardealership;

public class Employee {
    private String name;
    private int id;
    private double overallRating = 0; // tbe employee's overall rating with 0 to 5
    private int ratingCounter = 0;    // times that the employee has been rated

    public Employee(String employeeName, int employeeId) {
        name = employeeName;
        id = employeeId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setRating(double employeeRating) {
        overallRating = employeeRating;
    }

    public double getRating() {
        return overallRating;
    }

    public void setCounter(int value) {
        ratingCounter = value;
    }

    public int getCounter() {
        return ratingCounter;
    }
}
