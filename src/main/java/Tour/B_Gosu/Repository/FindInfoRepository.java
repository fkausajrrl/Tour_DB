package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.FindInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FindInfoRepository extends JpaRepository<FindInfo, String> {

    @Query(value = "DELETE FROM find " +
            "WHERE characterid = :ch AND\n +" +
            "title = :ti", nativeQuery = true)
    void deleteByCharacterIdAndTitle(int ch, String ti);

    Optional<FindInfo> findByCharacterid(int characterId);
}
