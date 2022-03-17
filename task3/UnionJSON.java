package task3;

import java.util.List;

import static task3.RecursJSON.recursUnionJSON;

public class UnionJSON {

    public Root union(Root root, List<ValuesJSON> valuesJSONList) {
        Root unionRoot;
        List<TestJSON> list;

        unionRoot = root;
        list = root.getTestJson();

        for (ValuesJSON values : valuesJSONList) {
            for (int i = 0; i < list.size(); i++) {
                if (values.getId() == list.get(i).getId()) {
                    list.get(i).setValue(values.getValues());
                }
                if (list.get(i).getValues() != null) {
                    recursUnionJSON(values, list.get(i));
                }
            }
        }
        return unionRoot;
    }
}
