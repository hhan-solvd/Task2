package com.solvd.cardealership;

public class Vehicle {
    private String model;
    private String color;
    private int year;
    private double price;

    public Vehicle(String vehicleModel, String vehicleColor,
                   int vehicleYear, double vehiclePrice) {
        model = vehicleModel;
        color = vehicleColor;
        year = vehicleYear;
        price = vehiclePrice;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }
}
