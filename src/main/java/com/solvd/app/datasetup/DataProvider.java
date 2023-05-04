package com.solvd.app.datasetup;

import com.solvd.app.exceptions.EmptyStringException;
import com.solvd.app.people.*;
import com.solvd.app.vehicles.*;

import java.util.ArrayList;

public class DataProvider {
    public static Customer[] predefinedCustomers() throws EmptyStringException {
        return new Customer[]{
                new Customer("Jack", 123456,
                        2000),
                new Customer("Kathy", 789012,
                        30000),
                new Customer("Hannah", 654321,
                        16000)
        };
    }

    public static Employee[] predefinedEmployees() throws EmptyStringException {
        return new Employee[]{
                new Employee("Lucy", 678),
                new Employee("Alan", 345)
        };
    }

    public static Manager[] predefinedManagers() throws EmptyStringException {
        return new Manager[]{
                new Manager("Alex", 776)
        };
    }

    public static Vehicle[] predefinedVehicles() throws EmptyStringException {
        return new Vehicle[]{
                new ElectricVehicle("Chevy Bolt", "grey",
                        2019, 20000, 20),
                new HybridVehicle("Toyota RAV4", "red",
                        2023, 30000, true),
                new GasVehicle("Nissan Sentra", "blue",
                        2022, 22000, 118)
        };
    }

    public static ArrayList<Integer> predefinedRatings() {
        ArrayList<Integer> ratings = new ArrayList<>();
        ratings.add(1);
        ratings.add(2);
        ratings.add(3);
        ratings.add(4);
        ratings.add(5);
        return ratings;
    }

    public static ArrayList<String> predefinedComments() {
        ArrayList<String> comments = new ArrayList<>();
        comments.add("Excellent service!");
        comments.add("Can be better!");
        comments.add("Great service!");
        return comments;
    }
}
