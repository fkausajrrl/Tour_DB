package Tour.B_Gosu.Controller;


import Tour.B_Gosu.Entity.CharacterInfo;
import Tour.B_Gosu.Entity.Game1;
import Tour.B_Gosu.Repository.CharacterInfoRepository;
import Tour.B_Gosu.Repository.Game1_InfoRepository;
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
    private final Game1_InfoRepository game1InfoRepository;
    private final CharacterInfoRepository characterInfoRepository;


    public Game1_Controller(Game1_InfoService game1_infoService, Game1_InfoRepository game1InfoRepository, CharacterInfoRepository characterInfoRepository) {
        this.game1_infoService = game1_infoService;
        this.game1InfoRepository = game1InfoRepository;
        this.characterInfoRepository = characterInfoRepository;
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveGameData(@RequestParam("characterid") int characterid, @RequestParam("score") int score,
                                               @RequestParam("money") int money){

        Optional<CharacterInfo> ch_infos = characterInfoRepository.findByCharacterid(characterid);  //character table에서 characterid로 조회
        if(ch_infos.isPresent()){ //존재 한다면
            CharacterInfo ch = ch_infos.get();
            int t_money = ch.getTotal_money() + money; //db에 저장된 현재 total_money가져와서 더하기
            ch.setTotal_money(t_money);
        }
        Game1 gameInfo = game1InfoRepository.findByCharacterid(characterid); //game1 정보 조회

        Game1 game1 = new Game1();
        game1.setCharacterid(characterid);
        game1.setTotal_score1(gameInfo.getTotal_score1() + score);

        if(gameInfo.getMax_score1() <= score){
            game1.setMax_score1(score);
        }
        else{
            game1.setMax_score1(gameInfo.getMax_score1());
        }
        game1_infoService.save(game1);
        return ResponseEntity.ok("L");
    }
}
