package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.AnswerInfo;
import Tour.B_Gosu.Service.AnswerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bgosu/api")
public class AnswerController {
    private final AnswerInfoService answerInfoService;
    @Autowired
    public AnswerController(AnswerInfoService answerInfoService) {
        this.answerInfoService = answerInfoService;
    }

    @PostMapping("/question")
    public ResponseEntity<String> saveDataFromFrontend(@RequestParam("answer_id") String answer_id,@RequestParam("r_tag3") String r_tag3,
                                                  @RequestParam("r_tag4") String r_tag4,@RequestParam("r_tag5") String r_tag5,
                                                  @RequestParam("r_tag3_1") String r_tag3_1,@RequestParam("s_tag1") String s_tag1,
                                                  @RequestParam("ct_tag4") String ct_tag4,@RequestParam("ct_tag2") String ct_tag2,
                                                  @RequestParam("ct_tag3") String ct_tag3,@RequestParam("ct_tag1") String ct_tag1) {
        AnswerInfo info = new AnswerInfo();
        info.setAnswer_id(answer_id);
        info.setCt_tag1(ct_tag1);
        info.setCt_tag2(ct_tag2);
        info.setCt_tag3(ct_tag3);
        info.setCt_tag4(ct_tag4);
        info.setR_tag3(r_tag3);
        info.setR_tag4(r_tag4);
        info.setR_tag5(r_tag5);
        info.setR_tag3_1(r_tag3_1);
        info.setS_tag1(s_tag1);

        answerInfoService.saveDataFromFrontend(info);
        return ResponseEntity.ok("데이터 저장 완료");
    }
}
