package collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Employee;

import java.util.TreeSet;

public class EmployeeList {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeList.class);
    protected static TreeSet<String> employeeList = new TreeSet<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee.toString());
    }

    public void printEmployeeList() {
        for (String employee : employeeList) {
            LOGGER.info(employee);
        }
    }
}
