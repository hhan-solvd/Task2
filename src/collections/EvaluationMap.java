package collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;


public class EvaluationMap {
    private static final Logger LOGGER = LogManager.getLogger(CustomerList.class);
    protected static HashMap<Integer, ArrayList<String>> evaluationMap = new HashMap<>();

    public void addEvaluation(Integer key, String value) {
        if (evaluationMap.containsKey(key)) {
            evaluationMap.get(key).add(value);
        } else {
            ArrayList<String> valueList = new ArrayList<>();
            valueList.add(value);
            evaluationMap.put(key, valueList);
        }
    }

    public void printEvaluationMap() {
        LOGGER.info(evaluationMap);
    }
}
