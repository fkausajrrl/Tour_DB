package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.*;
import Tour.B_Gosu.Repository.*;
import Tour.B_Gosu.Service.FindInfoService;
import jakarta.persistence.Column;
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

    @PostMapping("/check")
    public ResponseEntity<QuizInfo> ChallengeCheak(@RequestParam("title") String title){
        QuizInfo quizInfo = quizInfoRepository.findByTitle(title);
        return ResponseEntity.ok(quizInfo);
    }

    @PostMapping("/success") //(0)위도, 경도 확인  / (1)
    public ResponseEntity<String> ChallengeSuccess(@RequestParam("characterid") int characterid, @RequestParam("title") String title) {
        FindInfo findInfo = findInfoRepository.findByCharacterid(characterid);

        SuccessInfo successInfo = new SuccessInfo();
        successInfo.setTitle(title);
        successInfo.setCharacterid(characterid);
        successInfo.setSigungucode(findInfo.getSigungucode());
        successInfoRepository.save(successInfo);

        //성공하면 find 테이블 비우기
        if (findInfo.getCharacterid() == characterid) { //캐릭터id 있으면
            if (findInfo.getTitle().equals(title)) {
                findInfoRepository.deleteByCharacterIdAndTitle(characterid, title);
                Optional<CharacterInfo> characterInfo = characterInfoRepository.findByCharacterid(characterid);
                CharacterInfo characterInfo1 = characterInfo.get();
                characterInfo1.setTotal_money(characterInfo1.getTotal_money() + 30);
                characterInfo1.setCurrent_money(characterInfo1.getCurrent_money() + 30);

                characterInfoRepository.save(characterInfo1);

                return ResponseEntity.ok("J"); //find 테이블에서 삭제
            }
            return ResponseEntity.ok("G"); //find 테이블에는 있으나 삭제 실패.
        } else {
            return ResponseEntity.ok("H"); //find테이블에서 characterid를 찾지 못함.
        }
    }
}
