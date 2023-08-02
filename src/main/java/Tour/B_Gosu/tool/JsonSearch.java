package Tour.B_Gosu.tool;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonSearch {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일 로드
            File file = new File("src/main/java/Tour/json/DB데이터 확정_국문/39_data.json");

            // JSON 파싱
            JsonNode rootNode = objectMapper.readTree(file);

            // 항목 개수 확인
            int itemCount = rootNode.size();
            System.out.println("항목 개수: " + itemCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}