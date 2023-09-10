package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.DailyInfo;
import Tour.B_Gosu.Repository.DailyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyInfoService {
    private final DailyInfoRepository dailyInfoRepository;
    @Autowired
    public DailyInfoService(DailyInfoRepository dailyInfoRepository) {
        this.dailyInfoRepository = dailyInfoRepository;
    }

    public void saveDailyInfo(List<DailyInfo> daily){
        dailyInfoRepository.saveAll(daily);
    }
}
