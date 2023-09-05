package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.FindInfo;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import Tour.B_Gosu.Service.FindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bgosu/api/challenge")
public class FindInfoController {

    private final KorServiceInfoRepository korserviceInfoRepository;
    private final FindInfoService findInfoService;
    @Autowired
    public FindInfoController(KorServiceInfoRepository korserviceInfoRepository, FindInfoService findInfoService) {
        this.korserviceInfoRepository = korserviceInfoRepository;
        this.findInfoService = findInfoService;
    }

    @PostMapping("/accept")
    public ResponseEntity<String> challengeAccept(@RequestParam("answer_id") String answer_id, @RequestParam("title") String title) {
        KorServiceInfo firstKorServiceInfo = korserviceInfoRepository.findByTitle(title);
        
        FindInfo findInfo = new FindInfo();
        findInfo.setAnswer_id(answer_id);
        findInfo.setTitle(firstKorServiceInfo.getTitle());
        findInfo.setTitle_jp(firstKorServiceInfo.getTitle_jp());
        findInfo.setTitle_en(firstKorServiceInfo.getTitle_en());
        findInfo.setTitle_ch(firstKorServiceInfo.getTitle_ch());
        findInfo.setAddr1(firstKorServiceInfo.getAddr1());
        findInfo.setAddr2(firstKorServiceInfo.getAddr2());
        findInfo.setContenttypeid(firstKorServiceInfo.getContenttypeid());
        findInfo.setFirstimage(firstKorServiceInfo.getFirstimage());
        findInfo.setFirstimage2(firstKorServiceInfo.getFirstimage2());
        findInfo.setMapx(firstKorServiceInfo.getMapx());
        findInfo.setMapy(firstKorServiceInfo.getMapy());
        findInfo.setSigungucode(firstKorServiceInfo.getSigungucode());
        findInfo.setTel(firstKorServiceInfo.getTel());
        findInfo.setCharacter_id(firstKorServiceInfo.getCharacter_id());
        findInfo.setContants(firstKorServiceInfo.getContants());
        findInfo.setTag1(firstKorServiceInfo.getTag1());
        findInfo.setTag2(firstKorServiceInfo.getTag2());
        findInfo.setTag3(firstKorServiceInfo.getTag3());
        findInfo.setTag4(firstKorServiceInfo.getTag4());
        findInfo.setTag5(firstKorServiceInfo.getTag5());
        findInfo.setMenu(firstKorServiceInfo.getMenu());

        findInfoService.saveAcceptData(findInfo);

        return ResponseEntity.ok("Ok");
    }

//    @GetMapping("/check")
//    public ResponseEntity<List<KorServiceInfo>> getChallengeCheck(@RequestParam("title") String title) {
//        List<KorServiceInfo> check = korserviceInfoRepository.findByTitle(title);
//        return new ResponseEntity<>(check, HttpStatus.OK);
//    }
//
//    @PostMapping("/success")
//    public ResponseEntity<List<KorServiceInfo>> getChallengeSuccess(@RequestParam("title") String title) {
//        List<KorServiceInfo> success = korserviceInfoRepository.findByTitle(title);
//        return new ResponseEntity<>(success, HttpStatus.OK);
//    }
}
