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
        int type = ThreadLocalRandom.current().nextInt(1, 117); // 1 이상 9 미만
        DailyInfo dailyInfo = dailyInfoRepository.findByCount(type);
        String title = dailyInfo.getTitle();
        String detail = dailyInfo.getDaily_quiz();
        String total = title + ":" + detail;
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
