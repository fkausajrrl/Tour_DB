package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.QuizInfo;
import Tour.B_Gosu.Repository.QuizInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class QuizInfoService {
    private final QuizInfoRepository quizInfoRepository;

    public QuizInfoService(QuizInfoRepository quizInfoRepository) {
        this.quizInfoRepository = quizInfoRepository;
    }

    public void saveQuizData(String filePaths) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePaths);
            JsonNode jsonData = objectMapper.readTree(file); // JSON 파일 읽기

            if (jsonData.isArray()) {
                for (JsonNode node : jsonData) {
                    String title = node.get("title").asText();
                    String quiz_problem = node.get("quiz_problem").asText();
                    int quiz_answer = node.get("quiz_answer").asInt();


                    // 필요한 필드들로 새로운 DailyInfo 객체를 생성
                    QuizInfo quizInfo = new QuizInfo();
                    quizInfo.setTitle(title);
                    quizInfo.setQuiz_problem(quiz_problem);
                    quizInfo.setQuiz_answer(quiz_answer);

                    // 데이터베이스에 저장
                    quizInfoRepository.save(quizInfo);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
