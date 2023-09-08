package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Service.KorServiceInfoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                    String titleJp = item.has("titleJp") ? item.get("titleJp").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String titleEn = item.has("titleEn") ? item.get("titleEn").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String titleCh = item.has("titleCh") ? item.get("titleCh").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String addr1 = item.get("addr1").asText();
                    String addr2 = item.get("addr2").asText();
                    String contenttypeid = item.get("contenttypeid").asText();
                    String firstimage = item.get("firstimage").asText();
                    String firstimage2 = item.get("firstimage2").asText();
                    String mapx = item.get("mapx").asText();
                    String mapy = item.get("mapy").asText();
                    String sigungucode = item.get("sigungucode").asText();
                    String tel = item.get("tel").asText();
                    String contants =item.has("contants") ? item.get("contants").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag1 = item.has("tag1") ? item.get("tag1").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag2 = item.has("tag2") ? item.get("tag2").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag3 = item.has("tag3") ? item.get("tag3").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag4 = item.has("tag4") ? item.get("tag4").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String tag5 = item.has("tag5") ? item.get("tag5").asText() : ""; //필드 값 없을시 ' ' 공백 입력
                    String menu = item.has("menu") ? item.get("menu").asText() : ""; //필드 값 없을시 ' ' 공백 입력

                    // 필요한 필드들로 새로운 KorServiceInfo 객체를 생성
                    KorServiceInfo korServiceInfo = new KorServiceInfo();
                    korServiceInfo.setTitle(title);
                    korServiceInfo.setTitleJp(titleJp);
                    korServiceInfo.setTitleEn(titleEn);
                    korServiceInfo.setTitleCh(titleCh);
                    korServiceInfo.setAddr1(addr1);
                    korServiceInfo.setAddr2(addr2);
                    korServiceInfo.setContenttypeid(contenttypeid);
                    korServiceInfo.setFirstimage(firstimage);
                    korServiceInfo.setFirstimage2(firstimage2);
                    korServiceInfo.setMapx(mapx);
                    korServiceInfo.setMapy(mapy);
                    korServiceInfo.setSigungucode(sigungucode);
                    korServiceInfo.setTel(tel);
                    korServiceInfo.setContants(contants);
                    korServiceInfo.setTag1(tag1);
                    korServiceInfo.setTag2(tag2);
                    korServiceInfo.setTag3(tag3);
                    korServiceInfo.setTag4(tag4);
                    korServiceInfo.setTag5(tag5);
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
}