package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.DailyInfo;
import Tour.B_Gosu.Entity.StatisticsInfo;
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
import java.util.*;

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
        System.out.println("init");
    }

    public void saveBusanApi(String filePaths) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePaths);
            JsonNode jsonData = objectMapper.readTree(file); // JSON 파일 읽기

            JsonNode itemArray = jsonData.get("getVisitorStatInfo").get("body").get("items").get("item");

            if (itemArray.isArray()) {
                List<StatisticsInfo> columnValues1 = new ArrayList<>();
                List<StatisticsInfo> columnValues2 = new ArrayList<>();
                List<StatisticsInfo> columnValues3 = new ArrayList<>();
                List<StatisticsInfo> columnValues4 = new ArrayList<>();
                List<StatisticsInfo> columnValues5 = new ArrayList<>();
                List<StatisticsInfo> columnValues6 = new ArrayList<>();

                for (JsonNode node : itemArray) {

                    if (node.has("teens")) {  //10대
                        StatisticsInfo columnValues = new StatisticsInfo();
                        columnValues.setTitle(node.get("spot").asText()); //장소
                        columnValues.setTop10(Integer.parseInt(node.get("teens").asText()));
                        columnValues1.add(columnValues);
                    }
                    if (node.has("agetwenties")) { //20대
                        StatisticsInfo columnValues = new StatisticsInfo();
                        columnValues.setTitle(node.get("spot").asText());
                        columnValues.setTop10(Integer.parseInt(node.get("agetwenties").asText()));
                        columnValues2.add(columnValues);
                    }
                    if (node.has("agethirties")) { //30대
                        StatisticsInfo columnValues = new StatisticsInfo();
                        columnValues.setTitle(node.get("spot").asText());
                        columnValues.setTop10(Integer.parseInt(node.get("agethirties").asText()));
                        columnValues3.add(columnValues);
                    }
                    if (node.has("ageforties")) { //40대
                        StatisticsInfo columnValues = new StatisticsInfo();
                        columnValues.setTitle(node.get("spot").asText());
                        columnValues.setTop10(Integer.parseInt(node.get("ageforties").asText()));
                        columnValues4.add(columnValues);
                    }
                    if (node.has("agefifties")) { //50대
                        StatisticsInfo columnValues = new StatisticsInfo();
                        columnValues.setTitle(node.get("spot").asText());
                        columnValues.setTop10(Integer.parseInt(node.get("agefifties").asText()));
                        columnValues5.add(columnValues);
                    }
                    if (node.has("agesixties")) { //60대
                        StatisticsInfo columnValues = new StatisticsInfo();
                        columnValues.setTitle(node.get("spot").asText());
                        columnValues.setTop10(Integer.parseInt(node.get("agesixties").asText()));
                        columnValues6.add(columnValues);

                        // 필요한 필드들로 새로운 DailyInfo 객체를 생성
//                        DailyInfo dailyInfo = new DailyInfo();
//                        dailyInfo.setDaily_quiz(daily_quiz);
//                        dailyInfo.setTitle(title);

                        // 데이터베이스에 저장
//                        dailyInfoRepository.save(dailyInfo);
                    }
                    if (node.has("travel")) { //통계
                        String title = node.get("spot").asText();
                        String statistics = node.get("travel").asText();
                        if (!Objects.equals(statistics, "0")) {
                            String daily_quiz = "이 관광지에 여행 목적으로 방문한 내국인 수는 " + statistics + "명 입니다.";

                            // 필요한 필드들로 새로운 DailyInfo 객체를 생성
                            DailyInfo dailyInfo = new DailyInfo();
                            dailyInfo.setDaily_quiz(daily_quiz);
                            dailyInfo.setTitle(title);

                            // 데이터베이스에 저장
                            dailyInfoRepository.save(dailyInfo);
                        }

                    }
                }
                Collections.sort(columnValues1);
                Collections.sort(columnValues2);
                Collections.sort(columnValues3);
                Collections.sort(columnValues4);
                Collections.sort(columnValues5);
                Collections.sort(columnValues6);

                for (int i = 0; i < 3; i++) {
                    String top = columnValues1.get(i).getTitle();
                    DailyInfo dailyInfo = new DailyInfo();
                    dailyInfo.setDaily_quiz("10대에서 자주 방문하는 관광지에요.");
                    dailyInfo.setTitle(top);

                    // 데이터베이스에 저장
                    dailyInfoRepository.save(dailyInfo);
                }
                for (int i = 0; i < 3; i++) {
                    String top = columnValues2.get(i).getTitle();
                    DailyInfo dailyInfo = new DailyInfo();
                    dailyInfo.setDaily_quiz("20대에서 자주 방문하는 관광지에요.");
                    dailyInfo.setTitle(top);

                    // 데이터베이스에 저장
                    dailyInfoRepository.save(dailyInfo);
                }
                for (int i = 0; i < 3; i++) {
                    String top = columnValues3.get(i).getTitle();
                    DailyInfo dailyInfo = new DailyInfo();
                    dailyInfo.setDaily_quiz("30대에서 자주 방문하는 관광지에요.");
                    dailyInfo.setTitle(top);

                    // 데이터베이스에 저장
                    dailyInfoRepository.save(dailyInfo);
                }
                for (int i = 0; i < 3; i++) {
                    String top = columnValues4.get(i).getTitle();
                    DailyInfo dailyInfo = new DailyInfo();
                    dailyInfo.setDaily_quiz("40대에서 자주 방문하는 관광지에요.");
                    dailyInfo.setTitle(top);

                    // 데이터베이스에 저장
                    dailyInfoRepository.save(dailyInfo);
                }
                for (int i = 0; i < 3; i++) {
                    String top = columnValues5.get(i).getTitle();
                    DailyInfo dailyInfo = new DailyInfo();
                    dailyInfo.setDaily_quiz("50대에서 자주 방문하는 관광지에요.");
                    dailyInfo.setTitle(top);

                    // 데이터베이스에 저장
                    dailyInfoRepository.save(dailyInfo);
                }
                for (int i = 0; i < 3; i++) {
                    String top = columnValues6.get(i).getTitle();
                    DailyInfo dailyInfo = new DailyInfo();
                    dailyInfo.setDaily_quiz("60대에서 자주 방문하는 관광지에요.");
                    dailyInfo.setTitle(top);

                    // 데이터베이스에 저장
                    dailyInfoRepository.save(dailyInfo);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
