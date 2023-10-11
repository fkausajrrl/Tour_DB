package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.CharacterInfo;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Entity.UserInfo;
import Tour.B_Gosu.Repository.CharacterInfoRepository;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import Tour.B_Gosu.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
//필터 고장 난줄 알았으나 데이터가 부족한거였음.
@RestController
@RequestMapping("/bgosu/api/knto")
public class KntoController {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private CharacterInfoRepository characterInfoRepository;

    //character_id 받아와서 character테이블에서 user_id조회 -> User table에서 user_id로 조회해서 가져오기
    @GetMapping("/restaurant") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                     @RequestParam("tag1") String tag1, @RequestParam("tag2") String tag2,
                                                                     @RequestParam("characterid") int characterid) {
        int userid;
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findByCharacterid(characterid);
        if (characterInfo.isPresent()) {
            CharacterInfo ch = characterInfo.get();
            userid = ch.getUserid();
        } else {
            return ResponseEntity.notFound().build();
        }
        String tag3, tag4, tag5;

        Optional<UserInfo> userInfo = userInfoRepository.findByUserid(userid); //user table에서 user_id로 조회
        if (userInfo.isPresent()) {
            UserInfo u_info = userInfo.get();
            tag3 = u_info.getR_tag3();
            tag4 = u_info.getR_tag4();
            tag5 = u_info.getR_tag5();
        } else {
            // 해당 user table에 userid에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        List<KorServiceInfo> restaurants = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy); // 레포지토리에서 가져오는 로직
        // 필터링 로직
        Set<KorServiceInfo> filteredResultsSet = new LinkedHashSet<>(); //순서 정렬
        if (tag5.equals("3")) {
            filteredResultsSet.addAll(restaurants.stream() //tag5 제외 => tag5 값은 상관 없음(3)을 받았으니
                    .filter(info ->
                            info.getTag1().contains(tag1) &&
                                    info.getTag2().contains(tag2) &&
                                    info.getTag3().contains(tag3) &&
                                    info.getTag4().contains(tag4)
                    )
                    .toList());

            filteredResultsSet.addAll(restaurants.stream() //tag5, tag4 제외
                    .filter(info ->
                            info.getTag1().contains(tag1) &&
                                    info.getTag2().contains(tag2) &&
                                    info.getTag3().contains(tag3)
                    )
                    .toList());

            filteredResultsSet.addAll(restaurants.stream() //tag5, tag4, tag3 제외
                    .filter(info ->
                            info.getTag1().contains(tag1) &&
                                    info.getTag2().contains(tag2)
                    )
                    .toList());
            List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

            if (filteredResults.isEmpty()) { //filteredResults 여부 확인
                return ResponseEntity.notFound().build(); // 데이터 x
            } else {
                return ResponseEntity.ok(filteredResults); // 데이터 O
            }
        }

        filteredResultsSet.addAll(restaurants.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4) &&
                                info.getTag5().contains(tag5)
                )
                .toList());

        filteredResultsSet.addAll(restaurants.stream() //tag5 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4)
                )
                .toList());

        filteredResultsSet.addAll(restaurants.stream() //tag5, tag4 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3)
                )
                .toList());

        filteredResultsSet.addAll(restaurants.stream() //tag5, tag4, tag3 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2)
                )
                .toList());
//tag1, tag2는 취향 x, 분류기 때문에 필터링 안꺼지게 할거임.


        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

        if (filteredResults.isEmpty()) { //filteredResults 여부 확인
            return ResponseEntity.notFound().build(); // 데이터 x
        } else {
            return ResponseEntity.ok(filteredResults); // 데이터 O
        }
    }

    @GetMapping("/tour") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getTouristSpotsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                      @RequestParam("characterid") int characterid) {
        int userid;
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findByCharacterid(characterid);
        if (characterInfo.isPresent()) {
            CharacterInfo ch = characterInfo.get();
            userid = ch.getUserid();
        } else {
            return ResponseEntity.notFound().build();
        }
        String tag1, tag2, tag3, tag4;

        Optional<UserInfo> userInfo = userInfoRepository.findByUserid(userid);

        if (userInfo.isPresent()) {
            UserInfo u_info = userInfo.get();
            tag1 = u_info.getCt_tag1();
            tag2 = u_info.getCt_tag2();
            tag3 = u_info.getCt_tag3();
            tag4 = u_info.getCt_tag4();
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        List<KorServiceInfo> touristSpots = korserviceInfoRepository.findTouristSpotsNearby(mapx, mapy);

        Set<KorServiceInfo> filteredResultsSet = new LinkedHashSet<>(); //순서 정렬
        //tag1 값이 3인 경우 tag1을 필터에서 제외 => tag1 값은 모두 출력됨.
        if (tag1.equals("3")) {
            filteredResultsSet.addAll(touristSpots.stream() //모두 일치
                    .filter(info ->
                            info.getTag2().contains(tag2) &&
                                    info.getTag3().contains(tag3) &&
                                    info.getTag4().contains(tag4)
                    ).toList());


            filteredResultsSet.addAll(touristSpots.stream() //tag4 제외
                    .filter(info ->
                            info.getTag2().contains(tag2) &&
                                    info.getTag3().contains(tag3)
                    ).toList());

            filteredResultsSet.addAll(touristSpots.stream() //tag4, tag3 제외
                    .filter(info ->
                            info.getTag2().contains(tag2)
                    ).toList());
            List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

            if (filteredResults.isEmpty()) { //filteredResults 여부 확인
                return ResponseEntity.notFound().build(); // 데이터 x
            } else {
                return ResponseEntity.ok(filteredResults); // 데이터 O
            }
        }

        filteredResultsSet.addAll(touristSpots.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4)
                ).toList());

//        System.out.println("count = " + (long) filteredResultsSet.size());

        filteredResultsSet.addAll(touristSpots.stream() //tag4 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3)
                ).toList());
//        System.out.println("count = " + (long) filteredResultsSet.size());

        filteredResultsSet.addAll(touristSpots.stream() //tag4, tag3 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2)
                ).toList());
//        System.out.println("count = " + (long) filteredResultsSet.size());

        filteredResultsSet.addAll(touristSpots.stream() //tag4, tag3, tag2 제외
                .filter(info ->
                        info.getTag1().contains(tag1)
                ).toList());
//        System.out.println("count = " + (long) filteredResultsSet.size());

        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

        if (filteredResults.isEmpty()) { //filteredResults 여부 확인
            return ResponseEntity.notFound().build(); // 데이터 x
        } else {
            return ResponseEntity.ok(filteredResults); // 데이터 O
        }
    }

    @GetMapping("/cultural") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getCulturalPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                        @RequestParam("characterid") int characterid) {
        int userid;
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findByCharacterid(characterid);
        if (characterInfo.isPresent()) {
            CharacterInfo ch = characterInfo.get();
            userid = ch.getUserid();
        } else {
            return ResponseEntity.notFound().build();
        }

        Optional<UserInfo> userInfo = userInfoRepository.findByUserid(userid);
        String tag1, tag2, tag3, tag4;

        if (userInfo.isPresent()) {
            UserInfo u_info = userInfo.get();
            tag1 = u_info.getCt_tag1();
            tag2 = u_info.getCt_tag2();
            tag3 = u_info.getCt_tag3();
            tag4 = u_info.getCt_tag4();
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }

        List<KorServiceInfo> culturalPlaces = korserviceInfoRepository.findCulturalPlacesNearby(mapx, mapy);

        Set<KorServiceInfo> filteredResultsSet = new LinkedHashSet<>(); //순서 정렬
        //tag1 값이 3인 경우 tag1을 필터에서 제외 => tag1 값은 모두 출력됨.
        if (tag1.equals("3")) {
            filteredResultsSet.addAll(culturalPlaces.stream() //모두 일치
                    .filter(info ->
                            info.getTag2().contains(tag2) &&
                                    info.getTag3().contains(tag3) &&
                                    info.getTag4().contains(tag4)
                    ).toList());


            filteredResultsSet.addAll(culturalPlaces.stream() //tag4 제외
                    .filter(info ->
                            info.getTag2().contains(tag2) &&
                                    info.getTag3().contains(tag3)
                    ).toList());

            filteredResultsSet.addAll(culturalPlaces.stream() //tag4, tag3 제외
                    .filter(info ->
                            info.getTag2().contains(tag2)
                    ).toList());
            List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

            if (filteredResults.isEmpty()) { //filteredResults 여부 확인
                return ResponseEntity.notFound().build(); // 데이터 x
            } else {
                return ResponseEntity.ok(filteredResults); // 데이터 O
            }
        }

        filteredResultsSet.addAll(culturalPlaces.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4)
                )
                .toList());
//        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(culturalPlaces.stream() //tag4 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3)
                )
                .toList());
//        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(culturalPlaces.stream() //tag4, tag3 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2)
                )
                .toList());
//        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(culturalPlaces.stream() //tag4, tag3, tag2 제외
                .filter(info ->
                        info.getTag1().contains(tag1)
                )
                .toList());
//        System.out.println("count = " + filteredResultsSet.stream().count());

        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

        if (filteredResults.isEmpty()) { //filteredResults 여부 확인
            return ResponseEntity.notFound().build(); // 데이터 x
        } else {
            return ResponseEntity.ok(filteredResults); // 데이터 O
        }
    }

    @GetMapping("/shopping") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getShoppingPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                        @RequestParam("characterid") int characterid) {
        int userid;
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findByCharacterid(characterid);
        if (characterInfo.isPresent()) {
            CharacterInfo ch = characterInfo.get();
            userid = ch.getUserid();
        } else {
            return ResponseEntity.notFound().build();
        }

        Optional<UserInfo> userInfo = userInfoRepository.findByUserid(userid);
        String tag1;
        String[] tag_s = new String[5];
        int mapping_count = 0;

        if (userInfo.isPresent()) {
            UserInfo answer = userInfo.get();
            tag1 = answer.getS_tag1();
            switch (tag1) {
                case "1" -> {  //명품
                    mapping_count = 1;
                    tag_s[0] = "1"; //백화점
                }
                case "2" -> {  //기념품
                    mapping_count = 2;
                    tag_s[0] = "2"; //전통시장
                    tag_s[1] = "6"; //잡화
                }
                case "3" -> {  //화장품
                    mapping_count = 2;
                    tag_s[0] = "1"; //백화점
                    tag_s[1] = "5"; //화장품
                }
                case "4" -> {  //잡화
                    mapping_count = 1;
                    tag_s[0] = "6"; //잡화
                }
                case "5" -> {  //의류
                    mapping_count = 4;
                    tag_s[0] = "1"; //백화점
                    tag_s[1] = "2"; //전통시장
                    tag_s[2] = "3"; //아울렛
                    tag_s[3] = "4"; //지하상가
                }
            }
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        List<KorServiceInfo> shoppingPlaces = korserviceInfoRepository.findShoppingPlacesNearby(mapx, mapy);

        Set<KorServiceInfo> filteredResultsSet = new LinkedHashSet<>(); //순서 정렬
        for (int i = 0; i < mapping_count; i++) {
            String tag_a = tag_s[i];
            filteredResultsSet.addAll(shoppingPlaces.stream() //모두 일치
                    .filter(info ->
                            info.getTag1().contains(tag_a)
                    )
                    .toList());
//            System.out.println("count = " + (long) filteredResultsSet.size());
        }
        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

        if (filteredResults.isEmpty()) { //filteredResults 여부 확인
            return ResponseEntity.notFound().build(); // 데이터 x
        } else {
            return ResponseEntity.ok(filteredResults); // 데이터 O
        }
    }

    @GetMapping("/enjoy") //구현 완료   tag1만 분류해서 주는게 맞는가? tag1값 다음에 tag2값 같이 해서 정렬 된 상태로 줘야하는 거 아닌가 -> 지우안테 물어보깅.
    // => 챌린지 말고 태그로만 사용해서 지도에 표시
    public ResponseEntity<List<KorServiceInfo>> getenjoyPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                     @RequestParam("tag1") String tag1) {

        List<KorServiceInfo> enjoyPlaces = korserviceInfoRepository.findEnjoyPlacesNearby(mapx, mapy);

        List<KorServiceInfo> enjoyPlaces2 = new ArrayList<>(enjoyPlaces.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1)
                )
                .toList());
//        System.out.println("count = " + (long) enjoyPlaces2.size());

        if (enjoyPlaces2.isEmpty()) { //filteredResults 여부 확인
            return ResponseEntity.notFound().build(); // 데이터 x
        } else {
            return ResponseEntity.ok(enjoyPlaces2); // 데이터 O
        }

    }

}
