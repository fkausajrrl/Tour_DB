package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.Game2;
import Tour.B_Gosu.Service.Game2_InfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bgosu/api/game2")
public class Game2_Controller {
    private final Game2_InfoService game2_infoService;


    public Game2_Controller(Game2_InfoService game2_infoService) {
        this.game2_infoService = game2_infoService;
    }
    @PostMapping("/save") //characterid, score2, money
    public ResponseEntity<String> saveGameData(@RequestParam("characterid") int characterid, @RequestParam("total_score2") int total_score2,
                                               @RequestParam("max_score2") int max_score2,@RequestParam("total_money2") int total_money2){
        Game2 game2 = new Game2();
        game2.setCharacterid(characterid);
        game2.setTotal_score2(total_score2);
        game2.setMax_score2(max_score2);
        game2.setTotal_money2(total_money2);

        game2_infoService.save(game2);
        return ResponseEntity.ok("데이터 저장 완료");
    }
}
//characterid 받아와서 character table에서 조회해서 max_score랑 current money반환하는 api 필요 (current money는 character table에서 조회해서 가져가야됨)
