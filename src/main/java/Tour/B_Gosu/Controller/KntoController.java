package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bgosu/api/knto")
public class KntoController {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;


    @GetMapping("/restaurant")
    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> restaurants = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy); // 레포지토리에서 가져오는 로직
//
//        List<KorServiceInfo> findInfos = new ArrayList<>();
//        for (KorServiceInfo restaurant : restaurants) {
//            KorServiceInfo findInfo = new KorServiceInfo();
//
//            findInfo.setFix("1");
//            findInfo.setCharacter_id("123");
//            findInfo.setTitle(restaurant.getTitle());
//            findInfo.setTitle_jp(restaurant.getTitle_jp());
//            findInfo.setTitle_en(restaurant.getTitle_en());
//            findInfo.setTitle_ch(restaurant.getTitle_ch());
//            findInfo.setAddr1(restaurant.getAddr1());
//            findInfo.setAddr2(restaurant.getAddr2());
//            findInfo.setContenttypeid(restaurant.getContenttypeid());
//            findInfo.setFirstimage(restaurant.getFirstimage());
//            findInfo.setFirstimage2(restaurant.getFirstimage2());
//            findInfo.setMapx(restaurant.getMapx());
//            findInfo.setMapy(restaurant.getMapy());
//            findInfo.setSigungucode(restaurant.getSigungucode());
//            findInfo.setTel(restaurant.getTel());
//            findInfo.setContants(restaurant.getContants());
//            findInfo.setTag1(restaurant.getTag1());
//            findInfo.setTag2(restaurant.getTag2());
//            findInfo.setTag3(restaurant.getTag3());
//            findInfo.setTag4(restaurant.getTag4());
//            findInfo.setTag5(restaurant.getTag5());
//            findInfo.setMenu(restaurant.getMenu());
//
//
//            // 새로운 KorServiceInfo 객체를 List에 추가
//            findInfos.add(findInfo);
//        }
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/tour")
    public ResponseEntity<List<KorServiceInfo>> getTouristSpotsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> touristSpots = korserviceInfoRepository.findTouristSpotsNearby(mapx, mapy);
        return new ResponseEntity<>(touristSpots, HttpStatus.OK);
    }

    @GetMapping("/cultural")
    public ResponseEntity<List<KorServiceInfo>> getCulturalPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> culturalPlaces = korserviceInfoRepository.findCulturalPlacesNearby(mapx, mapy);
        return new ResponseEntity<>(culturalPlaces, HttpStatus.OK);
    }

    @GetMapping("/shopping")
    public ResponseEntity<List<KorServiceInfo>> getShoppingPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> shoppingPlaces = korserviceInfoRepository.findShoppingPlacesNearby(mapx, mapy);
        return new ResponseEntity<>(shoppingPlaces, HttpStatus.OK);
    }
    @GetMapping("/enjoy")
    public ResponseEntity<List<KorServiceInfo>> getenjoyPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> enjoyPlaces = korserviceInfoRepository.findEnjoyPlacesNearby(mapx, mapy);
        return new ResponseEntity<>(enjoyPlaces, HttpStatus.OK);
    }

}