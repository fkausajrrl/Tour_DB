package Tour.B_Gosu.tool;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;

public class AddressToJson {
    public static void main(String[] args) {
        String inputFilePath = "src/main/java/Tour/json/test/knto_떡집_시군구구분 안됌.json";
        String outputFilePath = "src/main/java/Tour/json/test/sigungu_out.json";

        createAndSaveJson(inputFilePath, outputFilePath);
    }

    private static void createAndSaveJson(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }

            JSONArray inputJsonArray = new JSONArray(jsonData.toString());
            JSONArray outputJsonArray = new JSONArray();

            for (int i = 0; i < inputJsonArray.length(); i++) {
                JSONObject inputJsonObject = inputJsonArray.getJSONObject(i);
                String addr1 = inputJsonObject.getString("addr1");
                int sigunguValue = getSigunguValue(addr1);

                JSONObject outputJsonObject = new JSONObject();
                outputJsonObject.put("addr1", addr1);
                outputJsonObject.put("sigungu", sigunguValue);

                outputJsonArray.put(outputJsonObject);
            }

            saveJsonToFile(outputJsonArray, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getSigunguValue(String addr1) {
        // 주소에서 2번째 단어를 추출하여 군구 코드를 분류하는 로직 작성
        String[] addrTokens = addr1.split(" ");
        if (addrTokens.length >= 2) {
            String sigungu = addrTokens[1]; // 2번째 단어 (시군구)
            // 시군구에 따라 코드 분류
            switch (sigungu) {
                case "강서구":
                    return 1;
                case "금정구":
                    return 2;
                case "기장군":
                    return 3;
                case "남구":
                    return 4;
                case "동구":
                    return 5;
                case "동래구":
                    return 6;
                case "부산진구":
                    return 7;
                case "북구":
                    return 8;
                case "사상구":
                    return 9;
                case "사하구":
                    return 10;
                case "서구":
                    return 11;
                case "수영구":
                    return 12;
                case "연제구":
                    return 13;
                case "영도구":
                    return 14;
                case "중구":
                    return 15;
                case "해운대구":
                    return 16;
                default:
                    return 0; // 기본값
            }
        }
        return 0; // 기본값
    }

    private static void saveJsonToFile(JSONArray jsonArray, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}