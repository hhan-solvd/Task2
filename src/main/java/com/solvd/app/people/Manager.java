package com.solvd.app.people;

import com.solvd.app.exceptions.EmptyStringException;

import java.util.ArrayList;

public class Manager extends Employee {
    public Manager(String managerName, int managerId) throws EmptyStringException {
        super(managerName, managerId);
    }

    public void addEmployeeToList(Employee employee, ArrayList<Employee> employeeList) {
        employeeList.add(employee);
    }
}
