package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.CharacterInfo;
import Tour.B_Gosu.Entity.UserInfo;
import Tour.B_Gosu.Repository.CharacterInfoRepository;
import Tour.B_Gosu.Repository.UserInfoRepository;
import Tour.B_Gosu.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/find")
    public ResponseEntity<Integer> findAndroid_id(@RequestParam("charcter_id") int character_id,@RequestParam("android_id") String android_id) {
        Optional<UserInfo> userInfos = userInfoRepository.findById(android_id);

        if (userInfos.isPresent()) {
            //if -> charcter_id 있는 경우
            //else -> charcter_id 없는 경우
            // 해당 answer_id가 DB에 존재하는 경우 1을 반환
            return ResponseEntity.ok(1);
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 0을 반환
            return ResponseEntity.ok(0);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<Integer> saveDataFromFrontend(@RequestParam("android") String android, @RequestParam("r_tag3") String r_tag3,
                                                        @RequestParam("r_tag4") String r_tag4, @RequestParam("r_tag5") String r_tag5,
                                                        @RequestParam("r_tag3_1") String r_tag3_1, @RequestParam("s_tag1") String s_tag1,
                                                        @RequestParam("ct_tag4") String ct_tag4, @RequestParam("ct_tag2") String ct_tag2,
                                                        @RequestParam("ct_tag3") String ct_tag3, @RequestParam("ct_tag1") String ct_tag1,
                                                        @RequestParam("user_name") String user_name, @RequestParam("start_date") String start_date,
                                                        @RequestParam("end_date") String end_date) {
        UserInfo info = new UserInfo();
        info.setAndroid(android);
        info.setCt_tag1(ct_tag1);
        info.setCt_tag2(ct_tag2);
        info.setCt_tag3(ct_tag3);
        info.setCt_tag4(ct_tag4);
        info.setR_tag3(r_tag3);
        info.setR_tag4(r_tag4);
        info.setR_tag5(r_tag5);
        info.setR_tag3_1(r_tag3_1);
        info.setS_tag1(s_tag1);
        info.setUser_name(user_name);
        info.setStart_date(start_date);
        info.setEnd_date(end_date);

        userInfoService.saveDataFromFrontend(info); //user table에 저장
        CharacterInfo characterInfo = new CharacterInfo(); //첫 로그인 시 Character 객체 생성
        characterInfo.setUser_id(info.getUser_id());
        characterInfo.setType(0);
        characterInfo.setCurrent_money(0);

        characterInfoRepository.save(characterInfo);
        //user_id이걸 charater객체를 만들어서 character_id, user_id, type = 0, charater_name =???, current_money = 0;
        //character table에 저장 -> character_id를 영민이안테 줘.
        characterInfo.getCharacter_id(); //저장 했으니까 auto increse 된거라고 믿음.....................................................
        return ResponseEntity.ok(characterInfo.getUser_id()); //프론트로 character_id 보내줌.
    }
}