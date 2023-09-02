package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/bgosu/api/knto")
public class KntoController {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;

    @GetMapping("/restaurant")
    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> restaurants = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy); // 레포지토리에서 가져오는 로직
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