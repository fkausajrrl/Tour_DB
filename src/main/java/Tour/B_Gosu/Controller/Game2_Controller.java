package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.CharacterInfo;
import Tour.B_Gosu.Entity.Game2;
import Tour.B_Gosu.Repository.CharacterInfoRepository;
import Tour.B_Gosu.Repository.Game2_InfoRepository;
import Tour.B_Gosu.Service.Game2_InfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/bgosu/api/game2")
public class Game2_Controller {
    private final Game2_InfoService game2_infoService;
    private final Game2_InfoRepository game2InfoRepository;
    private final CharacterInfoRepository characterInfoRepository;


    public Game2_Controller(Game2_InfoService game2_infoService, Game2_InfoRepository game2InfoRepository, CharacterInfoRepository characterInfoRepository) {
        this.game2_infoService = game2_infoService;
        this.game2InfoRepository = game2InfoRepository;
        this.characterInfoRepository = characterInfoRepository;
    }
    @PostMapping("/save") //characterid, score2, money
    public ResponseEntity<String> saveGameData(@RequestParam("characterid") int characterid, @RequestParam("score") int score,
                                               @RequestParam("money") int money){

        Optional<CharacterInfo> ch_infos = characterInfoRepository.findByCharacterid(characterid);  //character table에서 characterid로 조회
        if(ch_infos.isPresent()){ //존재 한다면
            CharacterInfo ch = ch_infos.get();
            int t_money = ch.getTotal_money() + money; //db에 저장된 현재 total_money가져와서 더하기
            ch.setTotal_money(t_money);
        }
        Game2 gameInfo = game2InfoRepository.findByCharacterid(characterid); //game2 정보 조회

        Game2 game2 = new Game2();
        game2.setCharacterid(characterid);
        game2.setTotal_score2(gameInfo.getTotal_score2() + score);

        if(gameInfo.getMax_score2() <= score){
            game2.setMax_score2(score);
        }
        else{
            game2.setMax_score2(gameInfo.getMax_score2());
        }

        game2_infoService.save(game2);
        return ResponseEntity.ok("M");
    }
}
//characterid 받아와서 character table에서 조회해서 max_score랑 current money반환하는 api 필요 (current money는 character table에서 조회해서 가져가야됨)
