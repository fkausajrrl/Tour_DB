package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.UserInfo;
import Tour.B_Gosu.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    private final UserInfoRepository UserInfoInfoRepository;
    @Autowired
    public UserInfoService(UserInfoRepository UserInfoInfoRepository) {
        this.UserInfoInfoRepository = UserInfoInfoRepository;
    }

    public void saveDataFromFrontend(UserInfo info) {
        UserInfo UserInfoInfo = new UserInfo();
        UserInfoInfo.setAndroid(info.getAndroid());
        UserInfoInfo.setCTtag1(info.getCTtag1());
        UserInfoInfo.setCTtag2(info.getCTtag2());
        UserInfoInfo.setCTtag3(info.getCTtag3());
        UserInfoInfo.setCTtag4(info.getCTtag4());
        UserInfoInfo.setRtag3(info.getRtag3());
        UserInfoInfo.setRtag4(info.getRtag4());
        UserInfoInfo.setRtag5(info.getRtag5());
        UserInfoInfo.setRtag3Cafe(info.getRtag3Cafe());
        UserInfoInfo.setStag1(info.getStag1());
        UserInfoInfo.setUserName(info.getUserName());
        UserInfoInfo.setStartDate(info.getStartDate());
        UserInfoInfo.setEndDate(info.getEndDate());

        UserInfoInfoRepository.save(UserInfoInfo);
    }
}
