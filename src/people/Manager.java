package people;

import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private static final Logger LOGGER = LogManager.getLogger(Employee.class);
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

    public void addEmployeeToList(Employee employee, ArrayList<String> employeeList) {
        employeeList.add(employee.toString());
    }

    public void printAList(ArrayList<String> arrayList) {
        for (String object : arrayList) {
            LOGGER.info(object);
        }
    }

    public void printAMap(HashMap<Integer, ArrayList<String>> hashMap) {
        LOGGER.info(hashMap);
    }
}
