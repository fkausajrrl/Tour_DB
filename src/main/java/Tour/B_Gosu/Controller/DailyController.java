package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.DailyInfo;
import Tour.B_Gosu.Repository.DailyInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
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
    public void saveDailyInfoFromJsonFiles(String filePaths) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePaths);
            JsonNode jsonData = objectMapper.readTree(file); // JSON 파일 읽기

            if (jsonData.isArray()) {
                for (JsonNode node : jsonData) {
                    if (node.has("daily_quiz")) {
                        String daily_quiz = node.get("daily_quiz").asText();

                        // 필요한 필드들로 새로운 DailyInfo 객체를 생성
                        DailyInfo dailyInfo = new DailyInfo();
                        dailyInfo.setDaily_quiz(daily_quiz);

                        // 데이터베이스에 저장
                        dailyInfoRepository.save(dailyInfo);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
