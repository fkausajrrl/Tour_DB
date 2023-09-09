package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.CharacterInfo;
import Tour.B_Gosu.Entity.Game1;
import Tour.B_Gosu.Repository.CharacterInfoRepository;
import Tour.B_Gosu.Service.Game1_InfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/bgosu/api/game1")
public class Game1_Controller {
    private final Game1_InfoService game1_infoService;
    private final CharacterInfoRepository characterInfoRepository;


    public Game1_Controller(Game1_InfoService game1_infoService, CharacterInfoRepository characterInfoRepository) {
        this.game1_infoService = game1_infoService;
        this.characterInfoRepository = characterInfoRepository;
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveGameData(@RequestParam("characterid") int characterid, @RequestParam("total_score1") int total_score1,
                                               @RequestParam("max_score1") int max_score1,@RequestParam("total_money1") int total_money1){
        Game1 game1 = new Game1();
        game1.setCharacterid(characterid);
        game1.setTotal_score1(total_score1);
        game1.setMax_score1(max_score1);
        game1.setTotal_money1(total_money1);

        game1_infoService.save(game1);
        return ResponseEntity.ok("데이터 저장 완료");
    }

    @PostMapping("/save/name")
    public ResponseEntity<String> savename(@RequestParam("characterid") int characterid, @RequestParam("character_name") String character_name){
        Optional<CharacterInfo> ch_infos = characterInfoRepository.findByCharacterid(characterid);
        if(ch_infos.isPresent()){
            CharacterInfo ch = ch_infos.get();
            ch.setCharacter_name(character_name);
            characterInfoRepository.save(ch); // 변경 사항을 저장
            int ty = ch.getType();
            return ResponseEntity.ok(String.valueOf(ty));
        }else{
            // character가 존재하지 않을 경우 에러 응답을 반환합니다.
            return ResponseEntity.ok("I");
        }
    }
}
