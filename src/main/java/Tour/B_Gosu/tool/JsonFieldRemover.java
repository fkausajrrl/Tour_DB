package Tour.B_Gosu.tool;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import Tour.B_Gosu.Entity.KorServiceInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFieldRemover {
    public static void main(String[] args) {
        // JSON 파일 경로
        String filePath = "src/main/java/Tour/json/test/12_data.json";

        // JSON 데이터에서 특정 필드들을 지우고 새로운 JSON 데이터 생성
        List<ObjectNode> modifiedJsonDataList = removeFieldsFromJson(filePath);

        // 수정된 JSON 데이터를 파일에 저장
        saveToJsonFile(modifiedJsonDataList, "src/main/java/Tour/json/test/12_data2.json");
    }

    private static List<ObjectNode> removeFieldsFromJson(String filePath) {
        List<ObjectNode> modifiedJsonDataList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            KorServiceInfo[] korServiceInfos = objectMapper.readValue(file, KorServiceInfo[].class);

            for (KorServiceInfo korServiceInfo : korServiceInfos) {
                // JSON 데이터를 ObjectNode로 변환
                ObjectNode jsonData = objectMapper.convertValue(korServiceInfo, ObjectNode.class);

                // 필요없는 필드들을 지움
                jsonData.remove("areacode");
                jsonData.remove("booktour");
                jsonData.remove("cat1");
                jsonData.remove("cat2");
                jsonData.remove("cat3");
                jsonData.remove("contentid");
                jsonData.remove("createdtime");
                jsonData.remove("cpyrhtDivCd");
                jsonData.remove("mlevel");
                jsonData.remove("modifiedtime");
                jsonData.remove("zipcode");

                modifiedJsonDataList.add(jsonData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modifiedJsonDataList;
    }

    private static void saveToJsonFile(List<ObjectNode> jsonDataList, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            objectMapper.writeValue(file, jsonDataList);
            System.out.println("Modified JSON data saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}