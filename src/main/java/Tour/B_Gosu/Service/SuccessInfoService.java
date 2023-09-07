package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.FindInfo;
import Tour.B_Gosu.Entity.SuccessInfo;
import Tour.B_Gosu.Repository.FindInfoRepository;
import Tour.B_Gosu.Repository.SuccessInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuccessInfoService {
    private final SuccessInfoRepository successInfoRepository;
    @Autowired
    public SuccessInfoService(SuccessInfoRepository successInfoRepository) {
        this.successInfoRepository = successInfoRepository;
    }
    public void save(SuccessInfo info){
        successInfoRepository.save(info);
    }

}
