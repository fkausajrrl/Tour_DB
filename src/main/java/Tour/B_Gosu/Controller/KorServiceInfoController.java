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

    public List<KorServiceInfo> readJsonFiles(List<String> filePaths) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // "item" 배열의 요소들을 List<KorServiceInfo> 형태로 매핑
            List<KorServiceInfo> korServiceInfos = new ArrayList<>();

            for (String filePath : filePaths) {
                File file = new File(filePath);

                // JSON 파일 읽기
                JsonNode jsonData = objectMapper.readTree(file);

                // "items" 안에 있는 "item" 배열을 가져오기
                JsonNode itemArray = jsonData.get("response").get("body").get("items").get("item");

                // 각 요소들을 순회하면서 필요한 필드들을 추출하여 새로운 KorServiceInfo 객체로 변환
                for (JsonNode item : itemArray) {
                    String title = item.get("title").asText();
                    String title_jp = item.has("title_jp") ? item.get("title_jp").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String title_en = item.has("title_en") ? item.get("title_en").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String title_ch = item.has("title_ch") ? item.get("title_ch").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String addr1 = item.get("addr1").asText();
                    String addr2 = item.get("addr2").asText();
                    String contenttypeid = item.get("contenttypeid").asText();
                    String firstimage = item.get("firstimage").asText();
                    String firstimage2 = item.get("firstimage2").asText();
                    String mapx = item.get("mapx").asText();
                    String mapy = item.get("mapy").asText();
                    String sigungucode = item.get("sigungucode").asText();
                    String tel = item.get("tel").asText();
                    String character_id = item.has("character_id") ?item.get("character_id").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String contants =item.has("contants") ? item.get("contants").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag1 = item.has("tag1") ? item.get("tag1").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag2 = item.has("tag2") ? item.get("tag2").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag3 = item.has("tag3") ? item.get("tag3").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag4 = item.has("tag4") ? item.get("tag4").asText() : ""; //필드 값 없을시 ' ' 공백 입력
//                    String tag5 = item.has("tag5") ? item.get("tag5").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String menu = item.has("menu") ? item.get("menu").asText() : ""; //필드 값 없을시 ' ' 공백 입력

                    // 필요한 필드들로 새로운 KorServiceInfo 객체를 생성
                    KorServiceInfo korServiceInfo = new KorServiceInfo();
                    korServiceInfo.setTitle(title);
                    korServiceInfo.setTitle_jp(title_jp);
                    korServiceInfo.setTitle_en(title_en);
                    korServiceInfo.setTitle_ch(title_ch);
                    korServiceInfo.setAddr1(addr1);
                    korServiceInfo.setAddr2(addr2);
                    korServiceInfo.setContenttypeid(contenttypeid);
                    korServiceInfo.setFirstimage(firstimage);
                    korServiceInfo.setFirstimage2(firstimage2);
                    korServiceInfo.setMapx(mapx);
                    korServiceInfo.setMapy(mapy);
                    korServiceInfo.setSigungucode(sigungucode);
                    korServiceInfo.setTel(tel);
                    korServiceInfo.setCharacter_id(character_id);
                    korServiceInfo.setContants(contants);
                    korServiceInfo.setTag1(tag1);
                    korServiceInfo.setTag2(tag2);
                    korServiceInfo.setTag3(tag3);
                    korServiceInfo.setTag4(tag4);
//                    korServiceInfo.setTag5(tag5);
                    korServiceInfo.setMenu(menu);


                    // 새로운 KorServiceInfo 객체를 List에 추가
                    korServiceInfos.add(korServiceInfo);
                }
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