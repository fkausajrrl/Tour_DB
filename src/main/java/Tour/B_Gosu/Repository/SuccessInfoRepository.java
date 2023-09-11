package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.KorServiceInfo;
import Tour.B_Gosu.Entity.SuccessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SuccessInfoRepository extends JpaRepository<SuccessInfo, String> {
    @Query(value = "SELECT * FROM knto\n" +
            "WHERE contenttypeid = 11 AND\n" +
            "      6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(?1) - RADIANS(mapx)) / 2), 2) +\n" +
            "      COS(RADIANS(mapx)) * COS(RADIANS(?1)) * POWER(SIN((RADIANS(?2) - RADIANS(mapy)) / 2), 2))) * 1000 <= 5;", nativeQuery = true)
    List<KorServiceInfo> findEnjoyPlacesNearby(double mapX, double mapY, String tag1);

    List<SuccessInfo> findByCharacterid(int characterid);
}
