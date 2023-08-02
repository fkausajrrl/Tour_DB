package Tour.B_Gosu;

import Tour.B_Gosu.Controller.KorServiceInfoController;
import Tour.B_Gosu.Entity.KorServiceInfo;
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

	public BGosuApplication(KorServiceInfoController korServiceInfoController, KorServiceInfoService korServiceInfoService) {
		this.korServiceInfoController = korServiceInfoController;
		this.korServiceInfoService = korServiceInfoService;
	}

	public static void main(String[] args) throws IOException {

		AreaBaseListApplication.main(args);
		SpringApplication.run(BGosuApplication.class, args);
	}

	@PostConstruct
	public void saveKorServiceInfoFromFile() {

		List<String> filePaths = List.of(
				"src/main/java/Tour/json/DB데이터 확정_국문/12_data.json",
				"src/main/java/Tour/json/DB데이터 확정_국문/14_data.json",
				"src/main/java/Tour/json/DB데이터 확정_국문/38_data.json",
				"src/main/java/Tour/json/DB데이터 확정_국문/39_data.json",
				"src/main/java/Tour/json/인생네컷.json"
		);
		List<KorServiceInfo> korServiceInfos = korServiceInfoController.readJsonFiles(filePaths);
		korServiceInfoService.saveKorServiceInfoList(korServiceInfos);
	}
}
