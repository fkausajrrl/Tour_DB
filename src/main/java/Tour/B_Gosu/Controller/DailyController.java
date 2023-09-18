package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.DailyArCoreInfo;
import Tour.B_Gosu.Entity.DailyInfo;
import Tour.B_Gosu.Repository.DailyArCoreInfoRepository;
import Tour.B_Gosu.Repository.DailyInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/bgosu/api/daily")
public class DailyController {
    @PersistenceContext
    private EntityManager entityManager;
    private final DailyInfoRepository dailyInfoRepository;
    private final DailyArCoreInfoRepository dailyArCoreInfoRepository;


    public DailyController(DailyInfoRepository dailyInfoRepository, DailyArCoreInfoRepository dailyArCoreInfoRepository) {

        this.dailyInfoRepository = dailyInfoRepository;
        this.dailyArCoreInfoRepository = dailyArCoreInfoRepository;
    }

    @GetMapping("/tour") // tour, cultural /그거 아시나요~?~?~
    public ResponseEntity<DailyInfo> getCultualDaily() {
        int type = ThreadLocalRandom.current().nextInt(1, 117); // 1 이상 9 미만
        DailyInfo dailyInfo = dailyInfoRepository.findByCount(type);
        //tmi보고 돈 줄거면 여기 코드 추가하기
        return new ResponseEntity<>(dailyInfo, HttpStatus.OK);
    }

    //사진을 찍으면 해당 api 호출해서  db에서 su에 적힌 값 1로 바꾸기
    @PostMapping("/success")
    public ResponseEntity<Integer> dailySuccess(@RequestParam int characterid) {
        DailyArCoreInfo dailyArCoreInfo1 = dailyArCoreInfoRepository.findByCharacterid(characterid);
        dailyArCoreInfo1.setSu(1); //오늘 함(1) 값으로 바꾸기
        dailyArCoreInfoRepository.save(dailyArCoreInfo1);

        return ResponseEntity.ok(1); // 저장 됨
    }

    //지도에서 챌린지 버튼 누르면 챌린지 창 들어갈때 통신하기
    //사진 촬영 성공 여부 확인 api
    @PostMapping("/arcore")
    public ResponseEntity<Integer> dailyArCore(@RequestParam int characterid) {
        DailyArCoreInfo dailyArCoreInfo = dailyArCoreInfoRepository.findByCharacterid(characterid);
        int su = dailyArCoreInfo.getSu(); // 오늘 안함(0) / 오늘 함(1)

        return ResponseEntity.ok(su);
    }
}
