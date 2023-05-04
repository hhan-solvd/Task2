package com.solvd.app.services;

import com.solvd.app.people.Customer;
import com.solvd.app.people.Employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class Dealership {
    private static final Logger LOGGER = LogManager.getLogger(Dealership.class);
    private ArrayList<Customer> customerList;
    private ArrayList<Employee> employeeList;
    private ArrayList<Transaction> transactionList;
    private HashMap<Integer, ArrayList<String>> evaluationMap;

    public Dealership() {
        customerList = new ArrayList<>();
        employeeList = new ArrayList<>();
        transactionList = new ArrayList<>();
        evaluationMap = new HashMap<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public HashMap<Integer, ArrayList<String>> getEvaluationMap() {
        return evaluationMap;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void displayCustomers() {
        LOGGER.info("-------------Customer List----------------");
        LOGGER.info("Total number of customers: " + customerList.size());
        for (Customer customer : getCustomerList()) {
            LOGGER.info(customer);
        }
    }

    public void displayEmployees() {
        LOGGER.info("-------------Employee List----------------");
        LOGGER.info("Total number of employees: " + employeeList.size());
        for (Employee employee : getEmployeeList()) {
            LOGGER.info(employee);
        }
    }

    public void displayTransactions() {
        LOGGER.info("-------------Transaction List----------------");
        LOGGER.info("Total number of transactions: " + transactionList.size());
        for (Transaction transaction : getTransactionList()) {
            LOGGER.info(transaction);
        }
    }

    public void displayEvaluations() {
        LOGGER.info("-------------Employee Evaluation Map----------------");
        LOGGER.info(evaluationMap);
    }
}
