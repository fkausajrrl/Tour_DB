package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;

    @PostMapping("/accept")
    public ResponseEntity<String> challengeAccept(@RequestBody Map<String, String> requestBody) {
        String postTitle = requestBody.get("posttitle");
        List<KorServiceInfo> challengeInfos = korserviceInfoRepository.findByTitle(postTitle);
        System.out.println("challengeInfos = " + challengeInfos);
        return ResponseEntity.ok("챌린지 수락");
    }
//    @GetMapping("/check")
//    public ResponseEntity<List<KorServiceInfo>> getChallengeCheck(@RequestParam("title") String title) {
//        List<KorServiceInfo> check = korserviceInfoRepository.ChallengeCheck(title);
//        return new ResponseEntity<>(check, HttpStatus.OK);
//    }
//    @PostMapping("/success")
//    public ResponseEntity<List<KorServiceInfo>> getChallengeSuccess(@RequestParam("title") String title) {
//        List<KorServiceInfo> success = korserviceInfoRepository.ChallengeSuccess(title);
//        return new ResponseEntity<>(success, HttpStatus.OK);
//    }
}
