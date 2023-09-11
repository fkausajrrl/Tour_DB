package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.FindInfo;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Entity.SuccessInfo;
import Tour.B_Gosu.Repository.FindInfoRepository;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import Tour.B_Gosu.Repository.SuccessInfoRepository;
import Tour.B_Gosu.Service.FindInfoService;
import Tour.B_Gosu.Service.SuccessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/bgosu/api/challenge")
public class FindInfoController {

    private final KorServiceInfoRepository korserviceInfoRepository;
    private final FindInfoRepository findInfoRepository;
    private final FindInfoService findInfoService;
    private final SuccessInfoService successInfoService;
    private final SuccessInfoRepository successInfoRepository;

    @Autowired
    public FindInfoController(KorServiceInfoRepository korserviceInfoRepository, FindInfoService findInfoService,
                              FindInfoRepository findInfoRepository, SuccessInfoService successInfoService, SuccessInfoRepository successInfoRepository) {
        this.korserviceInfoRepository = korserviceInfoRepository;
        this.findInfoService = findInfoService;
        this.findInfoRepository = findInfoRepository;
        this.successInfoService = successInfoService;
        this.successInfoRepository = successInfoRepository;
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

        if(findInfos.getCharacterid() == characterid){ //캐릭터id 있으면
            if(findInfos.getTitle().equals(title)){
                findInfoRepository.deleteByCharacterIdAndTitle(characterid,title);
                return ResponseEntity.ok("J"); //find 테이블에서 삭제
            }
            return ResponseEntity.ok("G"); //find 테이블에는 있으나 삭제 실패.
        }
        else{
            return ResponseEntity.ok("H"); //find테이블에서 characterid를 찾지 못함.
        }

    }
//챌린지 성공 -> 돈 current_money랑 total_money에 추가해서 주기

//    @PostMapping("/check")
//    public ResponseEntity<Integer> getChallengeCheck(@RequestParam("characterid") int characterid) {
//        //successInfoRepository에 있는 쿼리 호출하는 부분 추가
//        Optional<FindInfo> challange_findInfo = findInfoRepository.findByUserId(UserId);
//
//
//        if (challange_findInfo.isPresent()) {
//            // 해당 answer_id가 DB에 존재하는 경우 1을 반환
//
//            SuccessInfo s_info = new SuccessInfo();
//
//            s_info.setTitle(challange_findInfo.get().getTitle());
//            s_info.setCharacterid(character_id);
//
//            successInfoService.save(s_info);
//
//            return ResponseEntity.ok(1);
//        } else {
//            // 해당 answer_id에 대한 데이터가 없을 경우 0을 반환
//            return ResponseEntity.ok(0);
//        }
//    }
    @PostMapping("/success")
    public ResponseEntity<String> ChallengeSuccess(@RequestParam("characterid") int characterid, @RequestParam("title") String title) {
        FindInfo findInfo = findInfoRepository.findByCharacterid(characterid);

        SuccessInfo successInfo = new SuccessInfo();
        successInfo.setTitle(title);
        successInfo.setCharacterid(characterid);
        successInfo.setSigungucode(findInfo.getSigungucode());
        successInfoRepository.save(successInfo);

        //성공하면 find 테이블 비우기
        if(findInfo.getCharacterid() == characterid){ //캐릭터id 있으면
            if(findInfo.getTitle().equals(title)){
                findInfoRepository.deleteByCharacterIdAndTitle(characterid,title);
                return ResponseEntity.ok("J"); //find 테이블에서 삭제
            }
            return ResponseEntity.ok("G"); //find 테이블에는 있으나 삭제 실패.
        }
        else{
            return ResponseEntity.ok("H"); //find테이블에서 characterid를 찾지 못함.
        }
    }
}
