package com.solvd.app.services;

import com.solvd.app.interfaces.IComparison;
import com.solvd.app.interfaces.IFilter;
import com.solvd.app.interfaces.IPrintInfo;
import com.solvd.app.people.Customer;
import com.solvd.app.people.Employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

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

    // Filter lists with generic Lambda function - Predicate
    public <T> ArrayList<T> filterWithPredicate(Predicate<T> filterList, ArrayList<T> list) {
        ArrayList<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (filterList.test(t)) {
                filteredList.add(t);
            }
        }

        return filteredList;
    }

    // Filter lists with generic Lambda function - BiPredicate
    public <T, U> ArrayList<T> filterWithBiPredicate(BiPredicate<T, U> filterList,
                                                     ArrayList<T> t, U u) {
        ArrayList<T> filteredList = new ArrayList<>();
        for (T element : t) {
            if (filterList.test(element, u)) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }

    // Print lists with generic Lambda function - Consumer
    public <T> void printList(Consumer<T> printList, ArrayList<T> list) {
        for (T t : list) {
            printList.accept(t);
        }
    }

    // Get a string list with generic Lambda function - Function
    public <T> ArrayList<String> getStringList(Function<T, String> stringList, ArrayList<T> list) {
        ArrayList<String> transformedList = new ArrayList<>();
        for (T t : list) {
            transformedList.add(stringList.apply(t));
        }

        return transformedList;
    }

    // Print message with generic Lambda function - BiConsumer
    public <T, U> void printMessage(BiConsumer<T, U> infoBiConsumer, T t, U u) {
        infoBiConsumer.accept(t, u);
    }

    // Filter lists with custom generic Lambda function that takes three parameters - IFilter
    public <T, U, V> ArrayList<T> filterWithCustomFunction(IFilter<T, U, V> filterList, ArrayList<T> t, U u, V v) {
        ArrayList<T> filteredList = new ArrayList<>();
        for (T element : t) {
            if (filterList.filter(element, u, v)) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }

    // Print info with custom generic Lambda function that takes three parameters - IPrintInfo
    public <T, U, V> void printWithCustomFunction(IPrintInfo<T, U, V> printList, T t, U u, V v) {
        printList.print(t, u, v);
    }

    // Compare two items with custom generic Lambda function - IComparison
    public <T, U> String compareWithCustomFunction(IComparison<T, U, String> sumList, T t, U u) {
        return sumList.compare(t, u);
    }

    public List<String> getAllEmployeeNames() {
        return employeeList.stream()
                .map(Employee::getName)
                .toList();
    }

    public List<Employee> getFiveStarsEmployees() {
        return employeeList.stream()
                .filter((Employee employee) -> (employee.getRating() == 5))
                .collect(Collectors.toList());
    }

    public List<Customer> getVIPCustomers() {
        return customerList.stream()
                .filter((Customer customer) -> (customer.getCustomerType().getType().equals("VIP Customers")))
                .collect(Collectors.toList());
    }

    public void sortCustomersWithBudget() {
        customerList.stream()
                .sorted(Comparator.comparingDouble(Customer::getBudget))
                .forEach(LOGGER::info);
    }

    public double getCustomerAverageBudget() {
        return customerList.stream()
                .mapToDouble(Customer::getBudget).average().getAsDouble();
    }

    public double getMostExpensiveVehicleSold() {
        return transactionList.stream()
                .max(Comparator.comparing(Transaction::getVehiclePrice))
                .get().getVehiclePrice();
    }

    // Get the number of transactions made by an employee
    public int getEmployeeTransactionNumber(Employee employee) {
        return (int) transactionList.stream()
                .filter(transaction -> transaction.getEmployeeName().equals(employee.getName()))
                .count();
    }

    public Integer getTotalTransactionAmount() {
        return transactionList.stream()
                .mapToInt(transaction -> (int) transaction.getVehiclePrice()).sum();
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
