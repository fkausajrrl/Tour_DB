package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Service.KorServiceInfoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class KorServiceInfoController {
    private final KorServiceInfoService korServiceInfoService;

    @Autowired
    public KorServiceInfoController(KorServiceInfoService korServiceInfoService) {
        this.korServiceInfoService = korServiceInfoService;
    }

    @PostMapping("/save")
    public void saveKorServiceInfo(@RequestBody List<KorServiceInfo> korServiceInfoList) {
        korServiceInfoService.saveKorServiceInfoList(korServiceInfoList);
    }

    public List<KorServiceInfo> readJsonFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            // JSON 파일 읽기
            JsonNode jsonData = objectMapper.readTree(file);

            // "items" 안에 있는 "item" 배열을 가져오기
            JsonNode itemArray = jsonData.get("response").get("body").get("items").get("item");

            // "item" 배열의 요소들을 List<KorServiceInfo> 형태로 매핑
            List<KorServiceInfo> korServiceInfos = new ArrayList<>();

            // 각 요소들을 순회하면서 필요한 필드들을 추출하여 새로운 KorServiceInfo 객체로 변환
            for (JsonNode item : itemArray) {
                String addr1 = item.get("addr1").asText();
                String addr2 = item.get("addr2").asText();
                String contenttypeid = item.get("contenttypeid").asText();
                String firstimage = item.get("firstimage").asText();
                String firstimage2 = item.get("firstimage2").asText();
                String mapx = item.get("mapx").asText();
                String mapy = item.get("mapy").asText();
                String tel = item.get("tel").asText();
                String title = item.get("title").asText();

                // 필요한 필드들로 새로운 KorServiceInfo 객체를 생성
                KorServiceInfo korServiceInfo = new KorServiceInfo();
                korServiceInfo.setAddr1(addr1);
                korServiceInfo.setAddr2(addr2);
                korServiceInfo.setContenttypeid(contenttypeid);
                korServiceInfo.setFirstimage(firstimage);
                korServiceInfo.setFirstimage2(firstimage2);
                korServiceInfo.setMapx(mapx);
                korServiceInfo.setMapy(mapy);
                korServiceInfo.setTel(tel);
                korServiceInfo.setTitle(title);

                // 새로운 KorServiceInfo 객체를 List에 추가
                korServiceInfos.add(korServiceInfo);
            }

            return korServiceInfos;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


// 이 코드는 json파일 데이터 외의 부분 지우는 코드
//    public List<KorServiceInfo> readJsonFile(String filePath) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            File file = new File(filePath);
//
//            // JSON 파일을 읽어옵니다.
//            JsonNode jsonData = objectMapper.readTree(file);
//
//            // "items" 안에 있는 "item" 배열을 가져옵니다.
//            JsonNode itemArray = jsonData.get("response").get("body").get("items").get("item");
//
//            // "item" 배열의 요소들을 List<KorServiceInfo> 형태로 매핑합니다.
//            List<KorServiceInfo> korServiceInfos = objectMapper.convertValue(itemArray, new TypeReference<List<KorServiceInfo>>() {});
//
//            return korServiceInfos;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }


// 이 밑의 코드가 원래 쓰던거
//    public List<KorServiceInfo> readJsonFile(String filePath) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            File file = new File(filePath);
//            return objectMapper.readValue(file, new TypeReference<List<KorServiceInfo>>() {});
//        } catch (IOException e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }
}