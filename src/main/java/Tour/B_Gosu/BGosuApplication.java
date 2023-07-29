package Tour.B_Gosu;

import Tour.B_Gosu.Controller.KorServiceInfoController;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Service.KorServiceInfoService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BGosuApplication {

	private final KorServiceInfoController korServiceInfoController;
	private final KorServiceInfoService korServiceInfoService;

	public BGosuApplication(KorServiceInfoController korServiceInfoController, KorServiceInfoService korServiceInfoService) {
		this.korServiceInfoController = korServiceInfoController;
		this.korServiceInfoService = korServiceInfoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BGosuApplication.class, args);
	}

	@PostConstruct
	public void saveKorServiceInfoFromFile() {
		String filePath = "src/main/java/Tour/json/DB데이터 확정_국문/한국관광공사_부산_음식점_DB저장.json";
		List<KorServiceInfo> korServiceInfoList = korServiceInfoController.readJsonFile(filePath);
		korServiceInfoService.saveKorServiceInfoList(korServiceInfoList);
	}
}
