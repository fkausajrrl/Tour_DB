package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.FindInfo;
import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Repository.FindRepository;
import Tour.B_Gosu.Repository.KorServiceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bgosu/api")
public class FixController {

    @Autowired
    private FindRepository findRepository;
    @GetMapping("/question")
    public ResponseEntity<String> saveRestaurantsToDatabase(@RequestBody List<KorServiceInfo> restaurants) {
        // restaurants 리스트를 Find 엔터티로 변환하고 데이터베이스에 저장
        List<FindInfo> finds = new ArrayList<>();
        for (KorServiceInfo restaurant : restaurants) {
            FindInfo find = new FindInfo();
            find.setFix("1"); //restaurant.getFix()
            find.setCharacter_id("123"); //restaurant.getCharacter_id()
            finds.add(find);
        }

        // 데이터베이스에 저장
        findRepository.saveAll(finds);

        return ResponseEntity.ok("데이터베이스에 저장되었습니다.");
    }
}