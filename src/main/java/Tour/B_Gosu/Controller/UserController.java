package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.CharacterInfo;
import Tour.B_Gosu.Entity.UserInfo;
import Tour.B_Gosu.Repository.CharacterInfoRepository;
import Tour.B_Gosu.Repository.UserInfoRepository;
import Tour.B_Gosu.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bgosu/api/question")
public class UserController {
    private final UserInfoService userInfoService;
    private final UserInfoRepository userInfoRepository;
    private final CharacterInfoRepository characterInfoRepository;
    @Autowired
    public UserController(UserInfoService userInfoService, UserInfoRepository userInfoRepository, CharacterInfoRepository characterInfoRepository) {
        this.userInfoService = userInfoService;
        this.userInfoRepository = userInfoRepository;
        this.characterInfoRepository = characterInfoRepository;
    }

    @GetMapping("/find") //부팅 시에 조회.
    public ResponseEntity<Integer> findUseId(@RequestParam("userId") int userId) {
        Optional<UserInfo> userInfos = userInfoRepository.findByUserId(userId);
        if (userInfos.isPresent()) {
            // 해당 character_id DB에 존재하는 경우 1을 반환
            return ResponseEntity.ok(1);
        } else {
            // 해당 character_id 대한 데이터가 없을 경우 0을 반환
            return ResponseEntity.ok(0);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<Integer> saveDataFromFrontend(@RequestParam("android") String android, @RequestParam("Rtag3") String Rtag3,
                                                        @RequestParam("Rtag4") String Rtag4, @RequestParam("Rtag5") String Rtag5,
                                                        @RequestParam("Rtag3Cafe") String Rtag3Cafe, @RequestParam("Stag1") String Stag1,
                                                        @RequestParam("CTtag4") String CTtag4, @RequestParam("CTtag2") String CTtag2,
                                                        @RequestParam("CTtag3") String CTtag3, @RequestParam("CTtag1") String CTtag1,
                                                        @RequestParam("userName") String userName, @RequestParam("startDate") String startDate,
                                                        @RequestParam("endDate") String endDate) {
        UserInfo info = new UserInfo();
        info.setAndroid(android);
        info.setCTtag1(CTtag1);
        info.setCTtag2(CTtag2);
        info.setCTtag3(CTtag3);
        info.setCTtag4(CTtag4);
        info.setRtag3(Rtag3);
        info.setRtag4(Rtag4);
        info.setRtag5(Rtag5);
        info.setRtag3Cafe(Rtag3Cafe);
        info.setStag1(Stag1);
        info.setUserName(userName);
        info.setStartDate(startDate);
        info.setEndDate(endDate);

        userInfoService.saveDataFromFrontend(info); //user table에 저장

        Optional<UserInfo> userInfo = userInfoRepository.findMyuser(android, startDate); //이걸로 user_id가져오기

        if (userInfo.isPresent()) {
            CharacterInfo characterInfo = new CharacterInfo();  //첫 로그인 시 Character 객체 생성
            characterInfo.setUserId(userInfo.get().getUserId());
            characterInfo.setType(0);
            characterInfo.setCurrentMoney(0);
            characterInfoRepository.save(characterInfo);
        } else {
            // 해당 android에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.ok(99); //user table 오류
        }
        return ResponseEntity.ok(userInfo.get().getUserId()); //프론트로 character_id 보내줌.
    }
}