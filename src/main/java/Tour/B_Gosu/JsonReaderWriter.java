package Tour.B_Gosu;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonReaderWriter {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\fkausajrrl\\Documents\\카카오톡 받은 파일\\한국관광공사_부산_음식점.json";
        String outputFilePath = "C:\\Users\\fkausajrrl\\Documents\\카카오톡 받은 파일\\한국관광공사_부산_음식점2.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // JSON 파일을 읽어옵니다.
            JsonNode jsonData = objectMapper.readTree(new File(inputFilePath));

            // "items" 안에 있는 "item" 배열을 가져옵니다.
            JsonNode itemArray = jsonData.get("response").get("body").get("items").get("item");

            // 새로운 JSON 객체를 생성하고 "items" 배열을 설정합니다.
            JsonNode newJsonData = objectMapper.createObjectNode();
            ((ObjectNode) newJsonData).set("items", itemArray);

            // JSON 파일로 저장합니다.
            objectMapper.writeValue(new File(outputFilePath), newJsonData);

            System.out.println("읽어온 내용을 " + outputFilePath + " 파일에 저장했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}