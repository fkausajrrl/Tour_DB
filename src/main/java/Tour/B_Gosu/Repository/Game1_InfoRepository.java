package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.Game1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game1_InfoRepository extends JpaRepository<Game1, String> {
    Game1 findByCharacterid(int characterid);
}
