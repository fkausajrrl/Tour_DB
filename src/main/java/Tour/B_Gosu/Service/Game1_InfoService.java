package Tour.B_Gosu.Service;

import Tour.B_Gosu.Entity.Game1;
import Tour.B_Gosu.Repository.Game1_InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game1_InfoService {
    private final Game1_InfoRepository game1_infoRepository;
    @Autowired
    public Game1_InfoService(Game1_InfoRepository game1InfoRepository) {
        game1_infoRepository = game1InfoRepository;
    }

    public void save(Game1 game1) {
        game1_infoRepository.save(game1);
    }
}
