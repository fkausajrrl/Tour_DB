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
		String filePath = "C:\\Users\\fkausajrrl\\Desktop\\Test\\B_Gosu\\src\\main\\java\\Tour\\json\\한국관광공사_부산_음식점.json";
		List<KorServiceInfo> korServiceInfoList = korServiceInfoController.readJsonFile(filePath);
		korServiceInfoService.saveKorServiceInfoList(korServiceInfoList);
	}
}
