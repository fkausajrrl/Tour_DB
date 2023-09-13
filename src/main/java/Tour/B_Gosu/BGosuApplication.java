package Tour.B_Gosu;

import Tour.B_Gosu.Controller.KorServiceInfoController;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Service.DailyInfoService;
import Tour.B_Gosu.Service.KorServiceInfoService;
import Tour.B_Gosu.Service.QuizInfoService;
import Tour.B_Gosu.tool.AreaBaseListApplication;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class BGosuApplication {
    private final KorServiceInfoController korServiceInfoController;
    private final KorServiceInfoService korServiceInfoService;
    private final DailyInfoService dailyInfoService;
    private final QuizInfoService quizInfoService;

    public BGosuApplication(KorServiceInfoController korServiceInfoController, KorServiceInfoService korServiceInfoService, DailyInfoService dailyInfoService, QuizInfoService quizInfoService) {
        this.korServiceInfoController = korServiceInfoController;
        this.korServiceInfoService = korServiceInfoService;
        this.dailyInfoService = dailyInfoService;
        this.quizInfoService = quizInfoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BGosuApplication.class, args);
    }

    @PostConstruct
    public void saveKorServiceInfoFromFile() {
        String[] args = new String[0];
        try {
            AreaBaseListApplication.main(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> filePaths = List.of(
//				"src/main/java/Tour/json/DB데이터 확정_국문/12_data.json",
//				"src/main/java/Tour/json/DB데이터 확정_국문/14_data.json",
//				"src/main/java/Tour/json/DB데이터 확정_국문/38_data.json",
//				"src/main/java/Tour/json/DB데이터 확정_국문/39_data.json",
                "src/main/java/Tour/json/Use/knto_0913_최종.json"//Knto + 챌린지 관련 데이터

        );
        List<KorServiceInfo> korServiceInfos = korServiceInfoController.readJsonFiles(filePaths);
        korServiceInfoService.saveKorServiceInfoList(korServiceInfos); //knto + 챌린지 내용 저장

        String filePath = "src/main/java/Tour/json/Use/daily.json"; //daily.json파일 경로 -->daily 데이터
        dailyInfoService.saveDailyInfoFromJsonFiles(filePath); //daily_quiz 데이터 저장

        String file_path = "src/main/java/Tour/json/Use/quiz.json";//챌린지 인증용 퀴즈(quiz) 데이터
        quizInfoService.saveQuizData(file_path); //quiz 데이터 저장
    }
}
