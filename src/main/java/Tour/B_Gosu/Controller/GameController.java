package Tour.B_Gosu.Controller;

import Tour.B_Gosu.Entity.*;
import Tour.B_Gosu.Repository.CharacterInfoRepository;
import Tour.B_Gosu.Repository.Game1_InfoRepository;
import Tour.B_Gosu.Repository.Game2_InfoRepository;
import Tour.B_Gosu.Repository.ItemInfoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/bgosu/api/game")
public class GameController {
    private final CharacterInfoRepository characterInfoRepository;
    private final ItemInfoRepository itemInfoRepository;
    private final Game1_InfoRepository game1InfoRepository;
    private final Game2_InfoRepository game2InfoRepository;


    public GameController(CharacterInfoRepository characterInfoRepository, ItemInfoRepository itemInfoRepository, Game1_InfoRepository game1InfoRepository, Game2_InfoRepository game2InfoRepository) {
        this.characterInfoRepository = characterInfoRepository;
        this.itemInfoRepository = itemInfoRepository;
        this.game1InfoRepository = game1InfoRepository;
        this.game2InfoRepository = game2InfoRepository;
    }
    @GetMapping("/info")
    public ResponseEntity<GameInfo> gameInfo(@RequestParam("characterid") int characterid){

        Optional<CharacterInfo> character = characterInfoRepository.findByCharacterid(characterid); // character 테이블에서 정보 조회
        ItemInfo item = itemInfoRepository.findByCharacterid(characterid); // item 테이블에서 정보 조회
        Game1 game1 = game1InfoRepository.findByCharacterid(characterid); // game1 테이블에서 정보 조회
        Game2 game2 = game2InfoRepository.findByCharacterid(characterid); // game2 테이블에서 정보 조회

        GameInfo gameinfo = new GameInfo();
        gameinfo.setCharacterid(characterid);
        gameinfo.setType(character.get().getType());
        gameinfo.setCharacter_name(character.get().getCharacter_name());
        gameinfo.setCurrent_money(character.get().getCurrent_money());
        gameinfo.setHead_fir(item.getHead_fir());
        gameinfo.setHead_sec(item.getHead_sec());
        gameinfo.setHead_thr(item.getHead_thr());
        gameinfo.setNeck_fir(item.getNeck_fir());
        gameinfo.setNeck_sec(item.getNeck_sec());
        gameinfo.setHand_fir(item.getHand_fir());
        gameinfo.setHand_sec(item.getHand_sec());
        gameinfo.setMax_score1(game1.getMax_score1());
        gameinfo.setMax_score2(game2.getMax_score2());

        return ResponseEntity.ok(gameinfo);
    }

    @PostMapping("/save/name")
    public ResponseEntity<String> savename(@RequestParam("characterid") int characterid, @RequestParam("character_name") String character_name){
        Optional<CharacterInfo> ch_infos = characterInfoRepository.findByCharacterid(characterid);
        if(ch_infos.isPresent()){
            CharacterInfo ch = ch_infos.get();
            ch.setCharacter_name(character_name);
            characterInfoRepository.save(ch); // 변경 사항을 저장
            return ResponseEntity.ok("K"); //이름 저장 완료
        }else{
            // character가 존재하지 않을 경우 에러 응답을 반환합니다.
            return ResponseEntity.ok("I");
        }
    }

    @PostMapping("/save/item") //GameInfo 객체 받아서 item저장하고
    public ResponseEntity<String> gameItemSave(@RequestBody GameInfo gameInfo){

        Optional<CharacterInfo> character = characterInfoRepository.findByCharacterid(gameInfo.getCharacterid()); // character 테이블에서 정보 조회
        ItemInfo item = itemInfoRepository.findByCharacterid(gameInfo.getCharacterid()); // item 테이블에서 정보 조회

        item.setHead_fir(gameInfo.getHead_fir());
        item.setHead_sec(gameInfo.getHead_sec());
        item.setHead_thr(gameInfo.getHead_thr());
        item.setNeck_fir(gameInfo.getNeck_fir());
        item.setNeck_sec(gameInfo.getNeck_sec());
        item.setHand_fir(gameInfo.getHand_fir());
        item.setHand_sec(gameInfo.getHand_sec());
        itemInfoRepository.save(item);

        character.get().setCurrent_money(gameInfo.getCurrent_money());
        characterInfoRepository.save(character.get());

        return ResponseEntity.ok("N"); // item 변경사항 저장하고 현재 돈도 저장 완료
    }
}
