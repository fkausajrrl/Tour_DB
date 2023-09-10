package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.DailyInfo;
import Tour.B_Gosu.Repository.DailyInfoRepository;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/bgosu/api/daily")
public class DailyController {
    private final DailyInfoRepository dailyInfoRepository;


    public DailyController(DailyInfoRepository dailyInfoRepository) {

        this.dailyInfoRepository = dailyInfoRepository;
    }
    //
    @GetMapping("/tour") // tour, cultural /그거 아시나요~?~?~
    public ResponseEntity<String> getCultualDaily() {
         int type = ThreadLocalRandom.current().nextInt(1, 4); // 1 이상 4 미만
        DailyInfo dailyInfo = dailyInfoRepository.findByCount(type);
        return new ResponseEntity<>(dailyInfo.getDaily_quiz(), HttpStatus.OK);
    }
    //db에 그거 아시나요~!에 대한 정보 들어있는 json파일 저장 로직
    public List<DailyInfo> readJsonFiles(List<String> filePaths) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<DailyInfo> dailyInfo = new ArrayList<>();

            for (String filePath : filePaths) {
                File file = new File(filePath);
                JsonNode jsonData = objectMapper.readTree(file); // JSON 파일 읽기

                //daily_quiz 값을 객체로 만들어서 daily테이블에 저장
                for (JsonNode item : jsonData) {
                    String daily_quiz = item.get("daily_quiz").asText();


                    // 필요한 필드들로 새로운 KorServiceInfo 객체를 생성
                    DailyInfo daily = new DailyInfo();
                    daily.setDaily_quiz(daily_quiz);


                    // 새로운 KorServiceInfo 객체를 List에 추가
                    dailyInfo.add(daily);
                }
            }
            return dailyInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
