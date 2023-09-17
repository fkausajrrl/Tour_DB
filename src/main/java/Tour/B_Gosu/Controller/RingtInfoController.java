package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.*;
import Tour.B_Gosu.Repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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

        ZoneId koreaZone = ZoneId.of("Asia/Seoul");
        LocalDate localDate = currentInstant.atZone(koreaZone).toLocalDate();

        // LocalDate에서 년, 월, 일을 얻어옵니다.
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        String bir = day+"/"+month+"/"+year;

        // 두 시간 간의 차이 계산
        Duration duration = Duration.between(dbTimestamp.toInstant(), currentInstant);

        // 차이를 일, 시간, 분 등으로 분해
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        String date = days + " D  " + hours + " H  " + minutes + " M  ";

        int size = successInfos.size();
        Set<String> uniqueSigunguSet = new HashSet<>();

        for (int i = 0; i < size; i++) {
            switch (successInfos.get(i).getSigungucode()) {
                case "1" -> uniqueSigunguSet.add("강서구");
                case "2" -> uniqueSigunguSet.add("금정구");
                case "3" -> uniqueSigunguSet.add("기장군");
                case "4" -> uniqueSigunguSet.add("남구");
                case "5" -> uniqueSigunguSet.add("동구");
                case "6" -> uniqueSigunguSet.add("동래구");
                case "7" -> uniqueSigunguSet.add("부산진구");
                case "8" -> uniqueSigunguSet.add("북구");
                case "9" -> uniqueSigunguSet.add("사상구");
                case "10" -> uniqueSigunguSet.add("사하구");
                case "11" -> uniqueSigunguSet.add("서구");
                case "12" -> uniqueSigunguSet.add("수영구");
                case "13" -> uniqueSigunguSet.add("연제구");
                case "14" -> uniqueSigunguSet.add("영도구");
                case "15" -> uniqueSigunguSet.add("중구");
                case "16" -> uniqueSigunguSet.add("해운대구");
            }
        }
        StringJoiner sigunguList = new StringJoiner(", ");
        uniqueSigunguSet.forEach(sigunguList::add);

        String area_name = uniqueSigunguSet.toString();

        RightInfo rightInfo = new RightInfo();
        rightInfo.setCharacterid(characterid);
        rightInfo.setTimes(date); //처리 로직 짜야댐.
        rightInfo.setSuccess_count(size);
        rightInfo.setSuccess_area(area_name); //success테이블에서 시군구 코드 가져와서 각 시군구 코드마다 동네 이름 맵핑해서 한 문장이나 만들어서 줄 계획.
        rightInfo.setTotal_score1(game1.getTotal_score1());
        rightInfo.setTotal_score2(game2.getTotal_score2());
        rightInfo.setTotal_money(characterInfo.get().getTotal_money());
        rightInfo.setType(characterInfo.get().getType());
        rightInfo.setTime(bir);
        rightInfo.setCharacter_name(characterInfo.get().getCharacter_name());

        return ResponseEntity.ok(rightInfo); //객체 정보 주기`!~!~!~!~!~!!~
    }
}
