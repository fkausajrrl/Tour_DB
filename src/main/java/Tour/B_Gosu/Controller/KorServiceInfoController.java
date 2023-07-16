package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Service.KorServiceInfoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class KorServiceInfoController {
    private final KorServiceInfoService korServiceInfoService;

    @Autowired
    public KorServiceInfoController(KorServiceInfoService korServiceInfoService) {
        this.korServiceInfoService = korServiceInfoService;
    }

    @PostMapping("/save")
    public void saveKorServiceInfo(@RequestBody List<KorServiceInfo> korServiceInfoList) {
        korServiceInfoService.saveKorServiceInfoList(korServiceInfoList);
    }

    public List<KorServiceInfo> readJsonFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            return objectMapper.readValue(file, new TypeReference<List<KorServiceInfo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}