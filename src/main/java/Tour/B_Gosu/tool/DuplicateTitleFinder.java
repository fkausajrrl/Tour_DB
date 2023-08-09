package Tour.B_Gosu.tool;

import com.fasterxml.jackson.databind.ObjectMapper;
import Tour.B_Gosu.Entity.KorServiceInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateTitleFinder {
    public static void main(String[] args) {
        // JSON 파일 경로
        String filePath = "src/main/java/Tour/json/test/39_data.json";

        // 중복된 title 찾기
        Set<String> duplicateTitles = findDuplicateTitles(filePath);

        // 중복된 title 출력
        for (String title : duplicateTitles) {
            System.out.println("Duplicate Title: " + title);
        }
    }

    private static Set<String> findDuplicateTitles(String filePath) {
        Set<String> duplicateTitles = new HashSet<>();
        Map<String, Integer> titleCountMap = new HashMap<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            KorServiceInfo[] korServiceInfos = objectMapper.readValue(file, KorServiceInfo[].class);

            for (KorServiceInfo korServiceInfo : korServiceInfos) {
                String title = korServiceInfo.getTitle();

                // title이 이미 등록된 경우 중복된 것으로 처리
                if (titleCountMap.containsKey(title)) {
                    duplicateTitles.add(title);
                } else {
                    titleCountMap.put(title, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return duplicateTitles;
    }
}