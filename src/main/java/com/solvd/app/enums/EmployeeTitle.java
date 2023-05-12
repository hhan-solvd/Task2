package com.solvd.app.enums;

public enum EmployeeTitle {
    MANAGER("Manager", 100000),
    SALESPERSON("Salesperson", 70000);

    private final String jobTitle;
    private final int salary;

    EmployeeTitle(String employeeTitle, int employeeSalary) {
        jobTitle = employeeTitle;
        salary = employeeSalary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getSalary() {
        return salary;
    }
}
