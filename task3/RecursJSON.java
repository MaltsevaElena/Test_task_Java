package task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecursJSON {

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String VALUE = "value";
    private static final String VALUES_LIST = "values";


    public static TestJSON recursUnionJSON(ValuesJSON valuesJSON, TestJSON testJson) {
        TestJSON newTestJson;
        List<TestJSON> testJsonList;

        newTestJson = testJson;
        testJsonList = testJson.getValues();

        for (int i = 0; i < testJsonList.size(); i++) {
            if (valuesJSON.getId() == testJsonList.get(i).getId()) {
                testJsonList.get(i).setValue(valuesJSON.getValues());
            }
            if (testJsonList.get(i).getValues() != null) {
                recursUnionJSON(valuesJSON, testJsonList.get(i));
            }
        }
        newTestJson.setValues(testJsonList);

        return newTestJson;
    }

    public static TestJSON recursTestsJson(Object it) {
        JSONObject testJsonObject;
        TestJSON testJson;
        List<TestJSON> valuesList;
        long id;
        String title;
        String value;

        testJsonObject = (JSONObject) it;

        id = (Long) testJsonObject.get(ID);
        title = (String) testJsonObject.get(TITLE);
        value = (String) testJsonObject.get(VALUE);

        valuesList = (List<TestJSON>) testJsonObject.get(VALUES_LIST);

        if (valuesList == null) {
            testJson = new TestJSON((int) id, title, value);
        } else {
            JSONArray JsonArray;

            valuesList = new ArrayList<>();
            JsonArray = (JSONArray) testJsonObject.get(VALUES_LIST);
            for (Object InnerIt : JsonArray) {
                valuesList.add(recursTestsJson(InnerIt));
            }

            testJson = new TestJSON((int) id, title, value, valuesList);
        }
        return testJson;
    }
}