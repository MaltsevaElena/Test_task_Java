package task3;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        SimpleParser simpleParser;
        List<ValuesJSON> valuesJSONList;

        File file1;
        File file2;

        Root root;
        Root unionRoot;
        UnionJSON unionJson;

        WriterJSON writerJSON;


        file1 = new File(args[0]);
        file2 = new File(args[1]);

        simpleParser = new SimpleParser();
        root = simpleParser.parse(file1);

        valuesJSONList = simpleParser.parseValue(file2);
        unionJson = new UnionJSON();

        unionRoot = unionJson.union(root, valuesJSONList);

        writerJSON = new WriterJSON();
        writerJSON.toJSON(unionRoot);
    }
}
