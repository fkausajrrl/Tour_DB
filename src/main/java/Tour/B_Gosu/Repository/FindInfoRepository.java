package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.FindInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FindInfoRepository extends JpaRepository<FindInfo, String> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM find WHERE characterid = :ch AND title = :ti", nativeQuery = true)
    FindInfo deleteByCharacterIdAndTitle(int ch, String ti);

    FindInfo findByCharacterid(int characterId);
}
