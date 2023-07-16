package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorServiceInfoService {
    private final KorServiceInfoRepository korServiceInfoRepository;

    @Autowired
    public KorServiceInfoService(KorServiceInfoRepository korServiceInfoRepository) {
        this.korServiceInfoRepository = korServiceInfoRepository;
    }

    public void saveKorServiceInfoList(List<KorServiceInfo> korServiceInfoList) {
        korServiceInfoRepository.saveAll(korServiceInfoList);
    }
}