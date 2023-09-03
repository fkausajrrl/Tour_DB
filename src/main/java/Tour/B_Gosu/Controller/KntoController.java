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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bgosu/api/knto")
public class KntoController {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;

    @GetMapping("/restaurant") // 모두 일치하는 경우 조회까지는 됨.
    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                     @RequestParam("tag1") String tag1, @RequestParam("tag2") String tag2,
                                                                     @RequestParam("tag3") String tag3, @RequestParam("tag4") String tag4,
                                                                     @RequestParam("tag5") String tag5) {
        List<KorServiceInfo> restaurants = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy, tag1, tag2, tag3, tag4, tag5); // 레포지토리에서 가져오는 로직
        // 필터링: 입력된 태그와 일치하는 결과만 유지
        // 취향과 분류에 대해서 /취향은 처음 받을건데 이걸 저장하는걸 어디할지(영민아 저장해줘 데헷) / 이걸 조회할때 같이 받으면 해결되긴 하는데 흠.
        Set<KorServiceInfo> filteredResultsSet = new LinkedHashSet<>(); //순서 정렬
        filteredResultsSet.addAll(restaurants.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4) &&
                                info.getTag5().contains(tag5)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(restaurants.stream() //tag5 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(restaurants.stream() //tag5, tag4 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(restaurants.stream() //tag5, tag4, tag3 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(restaurants.stream() //tag5, tag4, tag3, tag2 제외
                .filter(info ->
                        info.getTag1().contains(tag1)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);


        return new ResponseEntity<>(filteredResults, HttpStatus.OK);
    }
//restaurant원본
//    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy) {
//        List<KorServiceInfo> restaurants = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy); // 레포지토리에서 가져오는 로직
//        return new ResponseEntity<>(restaurants, HttpStatus.OK);
//    }


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