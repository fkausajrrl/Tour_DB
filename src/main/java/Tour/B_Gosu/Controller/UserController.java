package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.*;
import Tour.B_Gosu.Repository.*;
import Tour.B_Gosu.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import java.util.Optional;

@RestController
@RequestMapping("/bgosu/api/question")
public class UserController {
    private final UserInfoService userInfoService;
    private final UserInfoRepository userInfoRepository;
    private final CharacterInfoRepository characterInfoRepository;
    private final ItemInfoRepository itemInfoRepository;
    private final Game1_InfoRepository game1_infoRepository;
    private final Game2_InfoRepository game2_infoRepository;
    private final DailyArCoreInfoRepository dailyArCoreInfoRepository;

    @Autowired
    public UserController(UserInfoService userInfoService, UserInfoRepository userInfoRepository, CharacterInfoRepository characterInfoRepository, ItemInfoRepository itemInfoRepository, Game1_InfoRepository game1InfoRepository, Game2_InfoRepository game2InfoRepository, DailyArCoreInfoRepository dailyArCoreInfoRepository) {
        this.userInfoService = userInfoService;
        this.userInfoRepository = userInfoRepository;
        this.characterInfoRepository = characterInfoRepository;
        this.itemInfoRepository = itemInfoRepository;
        game1_infoRepository = game1InfoRepository;
        game2_infoRepository = game2InfoRepository;
        this.dailyArCoreInfoRepository = dailyArCoreInfoRepository;
    }

    @GetMapping("/find") //초기 부팅 시에 조회.
    public ResponseEntity<String> findUserId(@RequestParam("android") String android) {
        Optional<UserInfo> userInfos = userInfoRepository.findByAndroid(android);
        if (userInfos.isPresent()) {
            //            // 해당 android DB에 존재하는 경우 1을 반환 -> 우리 게임을 한 적이 있다.
            return ResponseEntity.ok("A");
        } else {
            // 해당 android 대한 데이터가 없을 경우 0을 반환 -> 우리 게임 처음이다.
            return ResponseEntity.ok("B");
        }
    }

    @PostMapping("/restart") //android로 user_id 조회 -> character_id 생성하기
    public ResponseEntity<String> newCharacterFrom(@RequestParam("android") String android, @RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date) {
        Optional<UserInfo> userInfos = userInfoRepository.findByAndroid(android);
        if (userInfos.isPresent()) { //android로 user정보 조회
            userInfos.get().setStart_date(start_date);
            userInfos.get().setEnd_date(end_date);
            userInfos.get().setTime(Timestamp.from(Instant.now()));
            userInfoRepository.save(userInfos.get());
            int userId = userInfos.get().getUserid(); //userid 알아내기
            Optional<CharacterInfo> ch_infos = characterInfoRepository.findTopByUseridOrderByCharacteridDesc(userId);
            if(ch_infos.isPresent()){
                int type;
                do {
                    type = ThreadLocalRandom.current().nextInt(1, 4); // 1 이상 4 미만
                } while (type == ch_infos.get().getType());

                CharacterInfo characterInfo = new CharacterInfo();  //첫 로그인 시 Character 객체 생성
                characterInfo.setUserid(userId);
                characterInfo.setType(type);
                characterInfo.setCurrent_money(0);
                characterInfoRepository.save(characterInfo);

                Optional<CharacterInfo> re_ch_info = characterInfoRepository.findTopByUseridOrderByCharacteridDesc(userId);
                int num = re_ch_info.get().getCharacterid();
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setCharacterid(num);
                itemInfoRepository.save(itemInfo);

                Game1 game1 = new Game1(); //게임 1 객체 기본 정보 저장
                game1.setCharacterid(num);
                game1.setMax_score1(0);
                game1.setTotal_score1(0);
                game1_infoRepository.save(game1);

                Game2 game2 = new Game2();
                game2.setCharacterid(num);
                game2.setMax_score2(0);
                game2.setTotal_score2(0);
                game2_infoRepository.save(game2);

                DailyArCoreInfo dailyArCoreInfo = new DailyArCoreInfo(); //DailyArCore 테이블에 객체 생성
                dailyArCoreInfo.setCharacterid(num);
                dailyArCoreInfo.setSu(0);
                dailyArCoreInfoRepository.save(dailyArCoreInfo);

                return ResponseEntity.ok(String.valueOf(num)); //다중 회차 캐릭터 생성.
            }else{
                return ResponseEntity.ok("C"); //character table에서 userId 조회 오류
            }
        } else {
            // 해당 android 대한 데이터가 없을 경우 8을 반환
            return ResponseEntity.ok("D");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDataFromFrontend(@RequestParam("android") String android, @RequestParam("r_tag3") String r_tag3,
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

        Optional<UserInfo> userInfo = userInfoRepository.findMyuser(android, start_date);

        if (userInfo.isPresent()) {
            int type;
            do {
                type = ThreadLocalRandom.current().nextInt(1, 4); // 1 이상 4 미만
            } while (type == 0);

            int userId = userInfo.get().getUserid();
            // 사용자 정보가 존재하면 user_id를 가져옵니다.   //첫 로그인 시 Character 객체 생성
            CharacterInfo characterInfo = new CharacterInfo();
            characterInfo.setUserid(userId);
            characterInfo.setType(type);
            characterInfo.setCurrent_money(0);
            characterInfoRepository.save(characterInfo); //캐릭터 생성

            Optional<CharacterInfo> characterInfo1 = characterInfoRepository.findByUserid(userId); //userid로 조회
            int num2 = characterInfo1.get().getCharacterid();
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.setCharacterid(num2);
            itemInfoRepository.save(itemInfo);

            Game1 game1 = new Game1(); //게임 1 객체 기본 정보 저장
            game1.setCharacterid(num2);
            game1.setMax_score1(0);
            game1.setTotal_score1(0);
            game1_infoRepository.save(game1);

            Game2 game2 = new Game2();
            game2.setCharacterid(num2);
            game2.setMax_score2(0);
            game2.setTotal_score2(0);
            game2_infoRepository.save(game2);

            DailyArCoreInfo dailyArCoreInfo = new DailyArCoreInfo(); //DailyArCore 테이블에 객체 생성
            dailyArCoreInfo.setCharacterid(num2);
            dailyArCoreInfo.setSu(0);
            dailyArCoreInfoRepository.save(dailyArCoreInfo);

            return ResponseEntity.ok(String.valueOf(num2)); //프론트로 characterid 보내줌.
        } else {
            // 사용자 정보가 존재하지 않을 경우에 대한 처리
            return ResponseEntity.ok("E");
        }
    }
}//승환이안테 type 주는거 이걸 캐릭터 테이블 생성할때 랜덤해서 넣어놔야댐