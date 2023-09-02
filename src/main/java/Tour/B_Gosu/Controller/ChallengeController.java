package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bgosu/api/challenge")
public class ChallengeController {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;

    @PostMapping("/accept")
    public ResponseEntity<String> challengeAccept(@RequestParam("title") String title) {
        List<KorServiceInfo> challengeInfos = korserviceInfoRepository.findByTitle(title);
        return ResponseEntity.ok("Challenge Info: " + challengeInfos.toString());
    }
    @GetMapping("/check")
    public ResponseEntity<List<KorServiceInfo>> getChallengeCheck(@RequestParam("title") String title) {
        List<KorServiceInfo> check = korserviceInfoRepository.findByTitle(title);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
    @PostMapping("/success")
    public ResponseEntity<List<KorServiceInfo>> getChallengeSuccess(@RequestParam("title") String title) {
        List<KorServiceInfo> success = korserviceInfoRepository.findByTitle(title);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
