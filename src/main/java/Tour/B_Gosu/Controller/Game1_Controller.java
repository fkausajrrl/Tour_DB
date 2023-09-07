package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.Game1;
import Tour.B_Gosu.Repository.Game1_InfoRepository;
import Tour.B_Gosu.Service.Game1_InfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bgosu/api/game1")
public class Game1_Controller {
    private final Game1_InfoService game1_infoService;


    public Game1_Controller(Game1_InfoService game1_infoService) {
        this.game1_infoService = game1_infoService;
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveGameData(@RequestParam("character_id") int character_id, @RequestParam("total_score1") int total_score1,
                                               @RequestParam("max_score1") int max_score1,@RequestParam("total_money1") int total_money1){
        Game1 game1 = new Game1();
        game1.setCharacter_id(character_id);
        game1.setTotal_score1(total_score1);
        game1.setTotal_score1(max_score1);
        game1.setTotal_money1(total_money1);

        game1_infoService.save(game1);
        return ResponseEntity.ok("데이터 저장 완료");
    }
}
