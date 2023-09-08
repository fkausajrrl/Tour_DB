package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.CharacterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterInfoRepository extends JpaRepository<CharacterInfo, String> {
}
