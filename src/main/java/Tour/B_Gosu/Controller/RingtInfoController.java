package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.*;
import Tour.B_Gosu.Repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bgosu/api")
public class RingtInfoController {
    private final Game1_InfoRepository game1InfoRepository;
    private final Game2_InfoRepository game2InfoRepository;
    private final CharacterInfoRepository characterInfoRepository;
    private final SuccessInfoRepository successInfoRepository;

    public RingtInfoController(Game1_InfoRepository game1InfoRepository, Game2_InfoRepository game2InfoRepository,
                               CharacterInfoRepository characterInfoRepository, SuccessInfoRepository successInfoRepository) {
        this.game1InfoRepository = game1InfoRepository;
        this.game2InfoRepository = game2InfoRepository;
        this.characterInfoRepository = characterInfoRepository;
        this.successInfoRepository = successInfoRepository;
    }

    @GetMapping("/information")
    public ResponseEntity<RightInfo> rightInfo(@RequestParam("characterid") int characterid) {
        Game1 game1 = game1InfoRepository.findByCharacterid(characterid);
        Game2 game2 = game2InfoRepository.findByCharacterid(characterid);
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findByCharacterid(characterid);
        List<SuccessInfo> successInfos = successInfoRepository.findByCharacterid(characterid);

        java.sql.Timestamp dbTimestamp = characterInfo.get().getTime(); // 데이터베이스에서 읽어온 시간

        // 현재 시간을 얻어옴
        Instant currentInstant = Instant.now();

        // 두 시간 간의 차이 계산
        Duration duration = Duration.between(dbTimestamp.toInstant(), currentInstant);

        // 차이를 일, 시간, 분 등으로 분해
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        String date = days +" D" + hours + " H" + minutes + " M";
        for(successInfos){

        }
        String area ="hello";

        RightInfo rightInfo = new RightInfo();
        rightInfo.setCharacterid(characterid);
        rightInfo.setTimes(date); //처리 로직 짜야댐.
        rightInfo.setSuccess_count(successInfo.getCount());
        rightInfo.setSuccess_area(area); //success테이블에서 시군구 코드 가져와서 각 시군구 코드마다 동네 이름 맵핑해서 한 문장이나 만들어서 줄 계획.
        rightInfo.setTotal_score1(game1.getTotal_score1());
        rightInfo.setTotal_score2(game2.getTotal_score2());
        rightInfo.setTotal_money(characterInfo.get().getTotal_money());

        return ResponseEntity.ok(rightInfo); //객체 정보 주기`!~!~!~!~!~!!~
    }
}
