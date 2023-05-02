package collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.Transaction;

import java.util.ArrayList;

public class TransactionList {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeList.class);
    protected static ArrayList<String> transactionList = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction.toString());
    }

    public void printTransactionList() {
        for (String transaction : transactionList) {
            LOGGER.info(transaction);
        }
    }
}
