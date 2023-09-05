package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.FindInfo;
import Tour.B_Gosu.Repository.FindInfoRepository;
import org.springframework.stereotype.Service;
@Service
public class FindInfoService {

    private final FindInfoRepository findInfoRepository;

    public FindInfoService(FindInfoRepository findInfoRepository) {
        this.findInfoRepository = findInfoRepository;
    }
    public void saveAcceptData(FindInfo info){
        findInfoRepository.save(info);
    }

}
