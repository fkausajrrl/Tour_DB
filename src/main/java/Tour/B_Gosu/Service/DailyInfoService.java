package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.DailyInfo;
import Tour.B_Gosu.Repository.DailyInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@EnableScheduling
public class DailyInfoService {
    private final DailyInfoRepository dailyInfoRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public DailyInfoService(DailyInfoRepository dailyInfoRepository) {
        this.dailyInfoRepository = dailyInfoRepository;
    }

    //    public void saveDailyInfo(List<DailyInfo> daily){
//        dailyInfoRepository.saveAll(daily);
//    }
//db에 그거 아시나요~!에 대한 정보 들어있는 json파일 저장 로직
    public void saveDailyInfoFromJsonFiles(String filePaths) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePaths);
            JsonNode jsonData = objectMapper.readTree(file); // JSON 파일 읽기

            if (jsonData.isArray()) {
                for (JsonNode node : jsonData) {
                    if (node.has("daily_quiz")) {
                        String daily_quiz = node.get("daily_quiz").asText();
                        String title = node.get("title").asText();

                        // 필요한 필드들로 새로운 DailyInfo 객체를 생성
                        DailyInfo dailyInfo = new DailyInfo();
                        dailyInfo.setDaily_quiz(daily_quiz);
                        dailyInfo.setTitle(title);

                        // 데이터베이스에 저장
                        dailyInfoRepository.save(dailyInfo);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Transactional
    @Scheduled(cron = "0 0 0 * * ?") // 매일 자정에 실행
    public void resetSuFieldAtMidnight() {
        // 자정에 실행되는 SQL 쿼리
        String sql = "UPDATE arcore SET su = 0";
        entityManager.createNativeQuery(sql).executeUpdate();
        System.out.println("hello");
    }
}
