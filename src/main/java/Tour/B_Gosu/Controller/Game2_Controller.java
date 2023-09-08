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
    @PostMapping("/save")
    public ResponseEntity<String> saveGameData(@RequestParam("userId") int userId, @RequestParam("totalScore2") int totalScore2,
                                               @RequestParam("maxScore2") int maxScore2,@RequestParam("totalMoney2") int totalMoney2){
        Game2 game2 = new Game2();
        game2.setUserId(userId);
        game2.setTotalScore2(totalScore2);
        game2.setTotalScore2(maxScore2);
        game2.setTotalMoney2(totalMoney2);

        game2_infoService.save(game2);
        return ResponseEntity.ok("데이터 저장 완료");
    }
}
