package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.Game2;
import Tour.B_Gosu.Repository.Game2_InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game2_InfoService {
    private final Game2_InfoRepository game2_infoRepository;
    @Autowired
    public Game2_InfoService(Game2_InfoRepository game2InfoRepository) {
        game2_infoRepository = game2InfoRepository;
    }

    public void save(Game2 game2) {
        game2_infoRepository.save(game2);
    }
}
