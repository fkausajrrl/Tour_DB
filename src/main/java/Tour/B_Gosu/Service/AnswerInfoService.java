package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.AnswerInfo;
import Tour.B_Gosu.Repository.AnswerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerInfoService {

    private final AnswerInfoRepository answerInfoRepository;
    @Autowired
    public AnswerInfoService(AnswerInfoRepository answerInfoRepository) {
        this.answerInfoRepository = answerInfoRepository;
    }

    public void saveDataFromFrontend(AnswerInfo info) {
        AnswerInfo answerInfo = new AnswerInfo();
        answerInfo.setAnswer_id(info.getAnswer_id());
        answerInfo.setCt_tag1(info.getCt_tag1());
        answerInfo.setCt_tag2(info.getCt_tag2());
        answerInfo.setCt_tag3(info.getCt_tag3());
        answerInfo.setCt_tag4(info.getCt_tag4());
        answerInfo.setR_tag3(info.getR_tag3());
        answerInfo.setR_tag4(info.getR_tag4());
        answerInfo.setR_tag5(info.getR_tag5());
        answerInfo.setR_tag3_1(info.getR_tag3_1());
        answerInfo.setS_tag1(info.getS_tag1());
        answerInfo.setName(info.getName());
        answerInfo.setStart_date(info.getStart_date());
        answerInfo.setEnd_date(info.getEnd_date());

        answerInfoRepository.save(answerInfo);
    }
}
