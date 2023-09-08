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
        UserInfoInfo.setCt_tag1(info.getCt_tag1());
        UserInfoInfo.setCt_tag2(info.getCt_tag2());
        UserInfoInfo.setCt_tag3(info.getCt_tag3());
        UserInfoInfo.setCt_tag4(info.getCt_tag4());
        UserInfoInfo.setR_tag3(info.getR_tag3());
        UserInfoInfo.setR_tag4(info.getR_tag4());
        UserInfoInfo.setR_tag5(info.getR_tag5());
        UserInfoInfo.setR_tag3_1(info.getR_tag3_1());
        UserInfoInfo.setS_tag1(info.getS_tag1());
        UserInfoInfo.setUser_name(info.getUser_name());
        UserInfoInfo.setStart_date(info.getStart_date());
        UserInfoInfo.setEnd_date(info.getEnd_date());

        UserInfoInfoRepository.save(UserInfoInfo);
    }
}
