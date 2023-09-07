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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bgosu/api/knto")
public class KntoController {

    @Autowired
    private KorServiceInfoRepository korserviceInfoRepository;
    @Autowired
    private CharacterInfoRepository characterInfoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

//character_id 받아와서 character테이블에서 user_id조회 -> User table에서 user_id로 조회해서 가져오기
    @GetMapping("/restaurant") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getRestaurantsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                     @RequestParam("tag1") String tag1, @RequestParam("tag2") String tag2,
                                                                     @RequestParam("character_id") int character_id) {
        String tag3, tag4, tag5;
        int user_id; //user_id를 저장할 공간
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findById(String.valueOf(character_id)); // 캐릭터 table에서 조회
        if (characterInfo.isPresent()) {
            CharacterInfo ch_info = characterInfo.get();
            user_id = ch_info.getUser_id(); //user_id를 가져올 수 있음.
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        Optional<UserInfo> userInfo = userInfoRepository.findById(String.valueOf(user_id)); //user table에서 user_id로 조회
        if (userInfo.isPresent()) {
            UserInfo u_info = userInfo.get();
            tag3 = u_info.getR_tag3();
            tag4 = u_info.getR_tag4();
            tag5 = u_info.getR_tag5();
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        List<KorServiceInfo> restaurants = korserviceInfoRepository.findRestaurantsNearby(mapx, mapy, tag1, tag2); // 레포지토리에서 가져오는 로직
        // 필터링 로직
        // 정렬한거 프론트 쪽에서 뽑아내는거 가능하다고 한 것 같은데 확인 필요.
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
    @GetMapping("/tour") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getTouristSpotsNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                      @RequestParam("character_id") int character_id) {
        String tag1, tag2, tag3, tag4;
        int user_id;  //user_id를 저장할 공간

        Optional<CharacterInfo> characterInfo = characterInfoRepository.findById(String.valueOf(character_id)); // 캐릭터 table에서 user_id 조회
        if (characterInfo.isPresent()) {
            CharacterInfo ch_info = characterInfo.get();
            user_id = ch_info.getUser_id(); //user_id를 가져올 수 있음.
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        Optional<UserInfo> userInfo = userInfoRepository.findById(String.valueOf(user_id));

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

        filteredResultsSet.addAll(touristSpots.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(touristSpots.stream() //tag4 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(touristSpots.stream() //tag4, tag3 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(touristSpots.stream() //tag4, tag3, tag2 제외
                .filter(info ->
                        info.getTag1().contains(tag1)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

        return new ResponseEntity<>(filteredResults, HttpStatus.OK);
    }
    @GetMapping("/cultural") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getCulturalPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                        @RequestParam("character_id") int character_id) {
        int user_id;  //user_id를 저장할 공간
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findById(String.valueOf(character_id)); // 캐릭터 table에서 user_id 조회

        if (characterInfo.isPresent()) {
            CharacterInfo ch_info = characterInfo.get();
            user_id = ch_info.getUser_id(); //user_id를 가져올 수 있음.
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        Optional<UserInfo> userInfo = userInfoRepository.findById(String.valueOf(user_id));
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

        filteredResultsSet.addAll(culturalPlaces.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3) &&
                                info.getTag4().contains(tag4)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(culturalPlaces.stream() //tag4 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2) &&
                                info.getTag3().contains(tag3)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(culturalPlaces.stream() //tag4, tag3 제외
                .filter(info ->
                        info.getTag1().contains(tag1) &&
                                info.getTag2().contains(tag2)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        filteredResultsSet.addAll(culturalPlaces.stream() //tag4, tag3, tag2 제외
                .filter(info ->
                        info.getTag1().contains(tag1)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + filteredResultsSet.stream().count());

        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);
        return new ResponseEntity<>(filteredResults, HttpStatus.OK);
    }
    @GetMapping("/shopping") //구현 완료
    public ResponseEntity<List<KorServiceInfo>> getShoppingPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                        @RequestParam("character_id") int character_id) {
        int user_id;  //user_id를 저장할 공간
        Optional<CharacterInfo> characterInfo = characterInfoRepository.findById(String.valueOf(character_id)); // 캐릭터 table에서 user_id 조회

        if (characterInfo.isPresent()) {
            CharacterInfo ch_info = characterInfo.get();
            user_id = ch_info.getUser_id(); //user_id를 가져올 수 있음.
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        Optional<UserInfo> userInfo = userInfoRepository.findById(String.valueOf(user_id));
        String tag1;
        String[] tag_s = new String[5];
        int mapping_count = 0;

        if (userInfo.isPresent()) {
            UserInfo answer = userInfo.get();
            tag1 = answer.getS_tag1();
            switch (tag1) {
                case "1":  //명품
                    mapping_count = 1;
                    tag_s[0] = "1"; //백화점
                    break;
                case "2":  //기념품
                    mapping_count = 2;
                    tag_s[0] = "2"; //전통시장
                    tag_s[1] = "6"; //잡화
                    break;
                case "3":  //화장품
                    mapping_count = 2;
                    tag_s[0] = "1"; //백화점
                    tag_s[1] = "5"; //화장품
                    break;
                case "4":  //잡화
                    mapping_count = 1;
                    tag_s[0] = "6"; //잡화
                    break;
                case "5":  //의류
                    mapping_count = 4;
                    tag_s[0] = "1"; //백화점
                    tag_s[1] = "2"; //전통시장
                    tag_s[2] = "3"; //아울렛
                    tag_s[3] = "4"; //지하상가
                    break;
            }
        } else {
            // 해당 answer_id에 대한 데이터가 없을 경우 적절한 응답 반환
            return ResponseEntity.notFound().build();
        }
        List<KorServiceInfo> shoppingPlaces = korserviceInfoRepository.findShoppingPlacesNearby(mapx, mapy);

        Set<KorServiceInfo> filteredResultsSet = new LinkedHashSet<>(); //순서 정렬
        for(int i = 0; i < mapping_count; i++){
            String tag_a = tag_s[i];
            filteredResultsSet.addAll(shoppingPlaces.stream() //모두 일치
                    .filter(info ->
                            info.getTag1().contains(tag_a)
                    )
                    .collect(Collectors.toList()));
            System.out.println("count = " + filteredResultsSet.stream().count());
        }
        List<KorServiceInfo> filteredResults = new ArrayList<>(filteredResultsSet);

        return new ResponseEntity<>(filteredResults, HttpStatus.OK);
    }
    @GetMapping("/enjoy") //구현 완료   tag1만 분류해서 주는게 맞는가? tag1값 다음에 tag2값 같이 해서 정렬 된 상태로 줘야하는 거 아닌가 -> 지우안테 물어보깅.
                            // => 챌린지 말고 태그로만 사용해서 지도에 표시
    public ResponseEntity<List<KorServiceInfo>> getenjoyPlacesNearby(@RequestParam("mapx") double mapx, @RequestParam("mapy") double mapy,
                                                                     @RequestParam("tag1") String tag1) {

        List<KorServiceInfo> enjoyPlaces = korserviceInfoRepository.findEnjoyPlacesNearby(mapx, mapy, tag1);

        List<KorServiceInfo> enjoyPlaces2 = new ArrayList<>();

        enjoyPlaces2.addAll(enjoyPlaces.stream() //모두 일치
                .filter(info ->
                        info.getTag1().contains(tag1)
                )
                .collect(Collectors.toList()));
        System.out.println("count = " + enjoyPlaces2.stream().count());

        return new ResponseEntity<>(enjoyPlaces2, HttpStatus.OK);
    }

}
