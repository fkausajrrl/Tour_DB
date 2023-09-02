//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FixService {
//
//    private final KntoRepository kntoRepository;
//    private final FindRepository findRepository;
//
//    @Autowired
//    public FixService(KntoRepository kntoRepository, FindRepository findRepository) {
//        this.kntoRepository = kntoRepository;
//        this.findRepository = findRepository;
//    }
//
//    public void saveFixData(double mapX, double mapY, String fix, String character_id) {
//        // knto 테이블에서 데이터 조회
//        List<KorServiceInfo> kntoData = kntoRepository.findRestaurantsNearby(mapX, mapY);
//
//        // 조회한 데이터를 find 테이블에 저장
//        List<Find> findData = new ArrayList<>();
//        for (KorServiceInfo kntoItem : kntoData) {
//            Find findItem = new Find();
//            findItem.setAddr1(kntoItem.getAddr1());
//            findItem.setAddr2(kntoItem.getAddr2());
//            findItem.setFix(fix); // 추가된 필드
//            findItem.setCharacterId(character_id); // 추가된 필드
//            // 나머지 필드 복사
//
//            findData.add(findItem);
//        }
//
//        findRepository.saveAll(findData);
//    }
//
//    public List<Find> getPlacesWithin2km(double mapX, double mapY) {
//        // find 테이블에서 2km 내의 목록을 조회
//        List<Find> placesWithin2km = findRepository.findPlacesWithin2km(mapX, mapY);
//
//        return placesWithin2km;
//    }
//}