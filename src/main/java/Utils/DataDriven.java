package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataDriven {

    public static JSONObject getTestData() {

        String jsonFilePath = "/TestData.json";

        InputStream inputStream =
                DataDriven.class.getResourceAsStream(jsonFilePath);

        if (inputStream == null) {
            try {
                java.io.File file = new java.io.File("testData.json");
                inputStream = new java.io.FileInputStream(file);

            } catch (Exception e) {
                throw new RuntimeException(
                        "Could not find testData.json file: " + e.getMessage()
                );
            }
        }

        JSONParser parser = new JSONParser();

        try {
            return (JSONObject) parser.parse(
                    new InputStreamReader(inputStream)
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> jsonReadercart(String key) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("src/main/resources/TestData.json"));
        List<String> values = new ArrayList<>();
        for (JsonNode node : root.get(key)) {
            values.add(node.asText());
        }
        return values;
    }


    public static String jsonReader(String key) {
        JSONObject data = getTestData();
        return (String) data.get(key);
    }


}