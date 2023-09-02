package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.FindInfo;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.FindRepository;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FindService {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;

    @Autowired
    private FindRepository findRepository;

    @Transactional
    @GetMapping("/restaurant")
    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(
            @RequestParam("mapx") double mapx,
            @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> dataToTransfer = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy);

        for (KorServiceInfo info : dataToTransfer) {
            // 데이터 중복 검사 등을 수행한 후에
            // Find 엔터티로 변환 후 저장
            FindInfo find = new FindInfo();
            find.setFix(info.getFix());
            find.setCharacter_id(info.getCharacter_id());
            find.setTitle(info.getTitle());
            find.setTitle_jp(info.getTitle_jp());
            find.setTitle_en(info.getTitle_en());
            find.setTitle_ch(info.getTitle_ch());
            find.setAddr1(info.getAddr1());
            find.setAddr2(info.getAddr2());
            find.setContenttypeid(info.getContenttypeid());
            find.setFirstimage(info.getFirstimage());
            find.setFirstimage2(info.getFirstimage2());
            find.setMapx(info.getMapx());
            find.setMapy(info.getMapy());
            find.setSigungucode(info.getSigungucode());
            find.setTel(info.getTel());
            find.setContants(info.getContants());
            find.setTag1(info.getTag1());
            find.setTag2(info.getTag2());
            find.setTag3(info.getTag3());
            find.setTag4(info.getTag4());
            find.setTag5(info.getTag5());
            find.setMenu(info.getMenu());
            // 필요한 다른 필드도 설정

            findRepository.save(find);
        }
        return null;
    }
}