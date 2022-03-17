package task3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WriterJSON {
    static final String baseFile = "report.json";

    public void toJSON(Root root) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), root);
        System.out.println("json created!");
    }
}
