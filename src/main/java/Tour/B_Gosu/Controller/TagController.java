package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/bgosu/api/tag")
public class TagController {
    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;
    @GetMapping("/restaurant")
    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> restaurants = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy); // 레포지토리에서 가져오는 로직
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    @GetMapping("/tour")
    public ResponseEntity<List<KorServiceInfo>> getTour_CalSpotsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
        List<KorServiceInfo> touristSpots = korserviceInfoRepository.findTouristSpotsNearby(mapx, mapy);
        List<KorServiceInfo> culturalPlaces = korserviceInfoRepository.findCulturalPlacesNearby(mapx, mapy);

        Set<KorServiceInfo> filteredResultsSet = new LinkedHashSet<>(); //순서 정렬
        filteredResultsSet.addAll(touristSpots);
        filteredResultsSet.addAll(culturalPlaces);
        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

        return new ResponseEntity<>(filteredResults, HttpStatus.OK);
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
