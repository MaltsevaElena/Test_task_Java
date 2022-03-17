package task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleParser {

    private static final String NAME = "tests";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String VALUE = "value";
    private static final String VALUES_LIST = "values";

    private JSONParser parser = new JSONParser();

    public List<ValuesJSON> parseValue(File file) {
        List<ValuesJSON> valuesJSONList = new ArrayList<>();
        JSONObject jsonObject;
        JSONArray valuesJsonArray;

        try (FileReader reader = new FileReader(file)) {

            jsonObject = (JSONObject) parser.parse(reader);
            valuesJsonArray = (JSONArray) jsonObject.get(VALUES_LIST);

            for (Object it : valuesJsonArray) {
                JSONObject valuesJsonObject;
                Long id;
                String value;

                valuesJsonObject = (JSONObject) it;
                id = (Long) valuesJsonObject.get(ID);
                value = (String) valuesJsonObject.get(VALUE);

                ValuesJSON valuesJSON = new ValuesJSON(Math.toIntExact(id), value);
                valuesJSONList.add(valuesJSON);
            }

        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valuesJSONList;
    }

    public Root parse(File file) {
        Root root;
        JSONObject jsonObject;
        JSONArray testsJsonArray;

        List<TestJSON> jsonList;

        root = new Root();


        try (FileReader reader = new FileReader(file)) {
            jsonObject = (JSONObject) parser.parse(reader);

            jsonList = new ArrayList<>();
            testsJsonArray = (JSONArray) jsonObject.get(NAME);

            for (Object it : testsJsonArray) {
                TestJSON testJson;

                testJson = RecursJSON.recursTestsJson(it);
                jsonList.add(testJson);
            }
            root.setTestJson(jsonList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return root;
    }

}
