package Tour.B_Gosu;

import Tour.B_Gosu.Controller.DailyController;
import Tour.B_Gosu.Controller.KorServiceInfoController;
import Tour.B_Gosu.Entity.DailyInfo;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Service.DailyInfoService;
import Tour.B_Gosu.Service.KorServiceInfoService;
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
	private final DailyController dailyController;
	private final DailyInfoService dailyInfoService;

	public BGosuApplication(KorServiceInfoController korServiceInfoController, KorServiceInfoService korServiceInfoService, DailyController dailyController, DailyInfoService dailyInfoService) {
		this.korServiceInfoController = korServiceInfoController;
		this.korServiceInfoService = korServiceInfoService;
		this.dailyController = dailyController;
		this.dailyInfoService = dailyInfoService;
	}

	public static void main(String[] args){
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
				"src/main/java/Tour/json/knto0909.json" //우리 db
//				"src/main/java/Tour/json/knto_관광지_완_0908.json",
//				"src/main/java/Tour/json/knto_문화지_완_0908.json",
//				"src/main/java/Tour/json/knto_방탈출_완_0909.json"
		);
		List<KorServiceInfo> korServiceInfos = korServiceInfoController.readJsonFiles(filePaths);
		korServiceInfoService.saveKorServiceInfoList(korServiceInfos);

		String filePath = "src/main/java/Tour/json/양식.json"; //daily.json파일 경로
		List<DailyInfo> dailyInfos = dailyController.readJsonFiles(filePaths); //json파일 처리 해서 객체 반환
		dailyInfoService.saveDailyInfo(dailyInfos);

	}
}
