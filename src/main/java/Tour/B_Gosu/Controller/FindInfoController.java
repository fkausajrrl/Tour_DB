package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.*;
import Tour.B_Gosu.Repository.*;
import Tour.B_Gosu.Service.FindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/bgosu/api/challenge")
public class FindInfoController {

    private final KorServiceInfoRepository korserviceInfoRepository;
    private final FindInfoRepository findInfoRepository;
    private final FindInfoService findInfoService;
    private final CharacterInfoRepository characterInfoRepository;
    private final SuccessInfoRepository successInfoRepository;
    private final QuizInfoRepository quizInfoRepository;


    @Autowired
    public FindInfoController(KorServiceInfoRepository korserviceInfoRepository, FindInfoRepository findInfoRepository,
                              FindInfoService findInfoService, CharacterInfoRepository characterInfoRepository,
                              SuccessInfoRepository successInfoRepository, QuizInfoRepository quizInfoRepository) {
        this.korserviceInfoRepository = korserviceInfoRepository;
        this.findInfoRepository = findInfoRepository;
        this.findInfoService = findInfoService;
        this.characterInfoRepository = characterInfoRepository;
        this.successInfoRepository = successInfoRepository;
        this.quizInfoRepository = quizInfoRepository;
    }


    @PostMapping("/accept")
    public ResponseEntity<String> challengeAccept(@RequestParam("characterid") int characterid, @RequestParam("title") String title) {
        KorServiceInfo firstKorServiceInfo = korserviceInfoRepository.findByTitle(title);

        FindInfo findInfo = new FindInfo();
        findInfo.setCharacterid(characterid);
        findInfo.setTitle(firstKorServiceInfo.getTitle());
        findInfo.setAuth(firstKorServiceInfo.getAuth());
        findInfo.setTitle_en(firstKorServiceInfo.getTitle_en());
//        findInfo.setTitle_ch(firstKorServiceInfo.getTitle_ch());
        findInfo.setAddr1(firstKorServiceInfo.getAddr1());
        findInfo.setAddr2(firstKorServiceInfo.getAddr2());
        findInfo.setContenttypeid(firstKorServiceInfo.getContenttypeid());
        findInfo.setFirstimage(firstKorServiceInfo.getFirstimage());
        findInfo.setFirstimage2(firstKorServiceInfo.getFirstimage2());
        findInfo.setMapx(firstKorServiceInfo.getMapx());
        findInfo.setMapy(firstKorServiceInfo.getMapy());
        findInfo.setSigungucode(firstKorServiceInfo.getSigungucode());
        findInfo.setTel(firstKorServiceInfo.getTel());
        findInfo.setContants(firstKorServiceInfo.getContants());
        findInfo.setTag1(firstKorServiceInfo.getTag1());
        findInfo.setTag2(firstKorServiceInfo.getTag2());
        findInfo.setTag3(firstKorServiceInfo.getTag3());
        findInfo.setTag4(firstKorServiceInfo.getTag4());
        findInfo.setTag5(firstKorServiceInfo.getTag5());
        findInfo.setMenu(firstKorServiceInfo.getMenu());

        findInfoService.saveAcceptData(findInfo);

        return ResponseEntity.ok("F");
    }

    @PostMapping("/drop")
    public ResponseEntity<String> challengeDrop(@RequestParam("characterid") int characterid, @RequestParam("title") String title) {
        FindInfo findInfos = findInfoRepository.findByCharacterid(characterid);

        if (findInfos.getCharacterid() == characterid) { //캐릭터id 있으면
            if (findInfos.getTitle().equals(title)) {
                findInfoRepository.deleteByCharacterIdAndTitle(characterid, title);
                return ResponseEntity.ok("J"); //find 테이블에서 삭제
            }
            return ResponseEntity.ok("G"); //find 테이블에는 있으나 삭제 실패.
        } else {
            return ResponseEntity.ok("H"); //find테이블에서 characterid를 찾지 못함.
        }

    }

    @PostMapping("/reference")
    public ResponseEntity<FindInfo> challengeFind(@RequestParam("characterid") int characterid) {
        FindInfo findInfo = findInfoRepository.findByCharacterid(characterid);
        return ResponseEntity.ok(findInfo);
    }

    //    @PostMapping("/check")
//    public ResponseEntity<QuizInfo> ChallengeCheck(@RequestParam("title") String title){
//        QuizInfo quizInfo = quizInfoRepository.findByTitle(title);
//        return ResponseEntity.ok(quizInfo);
//    }


    @PostMapping("/success")
    public ResponseEntity<?> ChallengeSuccess(@RequestParam("characterid") int characterid, @RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        FindInfo findInfo = findInfoRepository.findByCharacterid(characterid); //find 테이블에서 가져오기. //mapx, mapy
        double map_x = Double.parseDouble(findInfo.getMapx());
        double map_y = Double.parseDouble(findInfo.getMapy());
        double distance = calculateDistance(map_y, map_x, mapy, mapx);
        if (distance <= 50) { //성공,거리는 나중에 수정
            switch (findInfo.getAuth()) {
                case 0:
                    SuccessInfo successInfo = new SuccessInfo();
                    successInfo.setTitle(findInfo.getTitle());
                    successInfo.setCharacterid(characterid);
                    successInfo.setSigungucode(findInfo.getSigungucode());
                    successInfoRepository.save(successInfo);

                    Optional<CharacterInfo> characterInfo = characterInfoRepository.findByCharacterid(characterid);
                    CharacterInfo characterInfo1 = characterInfo.get();
                    characterInfo1.setTotal_money(characterInfo1.getTotal_money() + 3000);
                    characterInfo1.setCurrent_money(characterInfo1.getCurrent_money() + 3000);

                    characterInfoRepository.save(characterInfo1);
                    findInfoRepository.deleteByCharacterIdAndTitle(characterid, findInfo.getTitle());

                    return ResponseEntity.ok("0");
                case 1:
                    SuccessInfo successInfo1 = new SuccessInfo();
                    successInfo1.setTitle(findInfo.getTitle());
                    successInfo1.setCharacterid(characterid);
                    successInfo1.setSigungucode(findInfo.getSigungucode());
                    successInfoRepository.save(successInfo1);

                    Optional<CharacterInfo> characterInfo2 = characterInfoRepository.findByCharacterid(characterid);
                    CharacterInfo characterInfo3 = characterInfo2.get();
                    characterInfo3.setTotal_money(characterInfo3.getTotal_money() + 3000);
                    characterInfo3.setCurrent_money(characterInfo3.getCurrent_money() + 3000);

                    characterInfoRepository.save(characterInfo3);
                    findInfoRepository.deleteByCharacterIdAndTitle(characterid, findInfo.getTitle());
                    return ResponseEntity.ok("1");
                case 2: {
                    String title_1 = findInfo.getTitle();
                    SuccessInfo successInfo2 = new SuccessInfo();
                    successInfo2.setTitle(findInfo.getTitle());
                    successInfo2.setCharacterid(characterid);
                    successInfo2.setSigungucode(findInfo.getSigungucode());
                    successInfoRepository.save(successInfo2);

                    Optional<CharacterInfo> characterInfo4 = characterInfoRepository.findByCharacterid(characterid);
                    CharacterInfo characterInfo5 = characterInfo4.get();
                    characterInfo5.setTotal_money(characterInfo5.getTotal_money() + 3000);
                    characterInfo5.setCurrent_money(characterInfo5.getCurrent_money() + 3000);

                    characterInfoRepository.save(characterInfo5);

                    findInfoRepository.deleteByCharacterIdAndTitle(characterid, findInfo.getTitle()); //find테이블에서 지우기

                    QuizInfo quizInfo = quizInfoRepository.findByTitle(title_1);
                    return ResponseEntity.ok(quizInfo);//quiz 반환
                }
            }
        } else { //실패
            return ResponseEntity.ok("Z");
        }
        return ResponseEntity.ok("H");
    }


    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371000; // 지구 반지름 (미터)

        // 라디안으로 변환
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // 위도와 경도의 차이 계산
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Haversine 공식 계산
        double a = Math.pow(Math.sin(deltaLat / 2), 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}