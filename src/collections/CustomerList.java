package collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Customer;

import java.util.ArrayList;

public class CustomerList {
    private static final Logger LOGGER = LogManager.getLogger(CustomerList.class);
    protected static ArrayList<String> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer.toString());
    }

    public void printCustomerList() {
        for (String customer : customerList) {
            LOGGER.info(customer);
        }
    }
}
