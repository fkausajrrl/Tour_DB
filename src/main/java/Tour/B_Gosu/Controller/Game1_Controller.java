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
    public ResponseEntity<String> saveGameData(@RequestParam("userId") int userId, @RequestParam("totalScore1") int totalScore1,
                                               @RequestParam("maxScore1") int maxScore1,@RequestParam("totalMoney1") int totalMoney1){
        Game1 game1 = new Game1();
        game1.setUserId(userId);
        game1.setTotalScore1(totalScore1);
        game1.setTotalScore1(maxScore1);
        game1.setTotalMoney1(totalMoney1);

        game1_infoService.save(game1);
        return ResponseEntity.ok("데이터 저장 완료");
    }
}
