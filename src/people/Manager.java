package people;

import collections.EmployeeList;
import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;

public class Manager {
    private String name;
    private int id;

    public Manager(String managerName, int managerId) throws EmptyStringException {
        if (managerName.isEmpty()) {
            throw new EmptyStringException("The manager's name can not be empty!");
        }

        if (managerId < 0) {
            throw new NegativeNumberException("The manager's ID must be a non-negative integer!");
        }

        name = managerName;
        id = managerId;
    }

    public void addEmployeeToList(Employee employee, EmployeeList employeeList) {
        employeeList.addEmployee(employee);
    }
}
