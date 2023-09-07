package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.CharacterInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInfoRepository extends JpaRepository<CharacterInfo, String> {
}
