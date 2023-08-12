package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.KorServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorServiceInfoRepository extends JpaRepository<KorServiceInfo, String> {
    KorServiceInfo findByTitle(String title);
    @Query(value = "SELECT * FROM knto\n" +
            "WHERE contenttypeid = 39 AND \n" +
            "      6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(?1) - RADIANS(mapx)) / 2), 2) +\n" +
            "      COS(RADIANS(mapx)) * COS(RADIANS(?1)) * POWER(SIN((RADIANS(?2) - RADIANS(mapy)) / 2), 2))) <= 2;", nativeQuery = true)
    List<KorServiceInfo> findRestaurantsNearby(double mapX, double mapY);

    @Query(value = "SELECT * FROM knto\n" +
            "WHERE contenttypeid = 12 AND \n" +
            "      6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(?1) - RADIANS(mapx)) / 2), 2) +\n" +
            "      COS(RADIANS(mapx)) * COS(RADIANS(?1)) * POWER(SIN((RADIANS(?2) - RADIANS(mapy)) / 2), 2))) <= 2;", nativeQuery = true)
    List<KorServiceInfo> findTouristSpotsNearby(double mapX, double mapY);

    @Query(value = "SELECT * FROM knto\n" +
            "WHERE contenttypeid = 14 AND \n" +
            "      6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(?1) - RADIANS(mapx)) / 2), 2) +\n" +
            "      COS(RADIANS(mapx)) * COS(RADIANS(?1)) * POWER(SIN((RADIANS(?2) - RADIANS(mapy)) / 2), 2))) <= 2;", nativeQuery = true)
    List<KorServiceInfo> findCulturalPlacesNearby(double mapX, double mapY);

    @Query(value = "SELECT * FROM knto\n" +
            "WHERE contenttypeid = 38 AND \n" +
            "      6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(?1) - RADIANS(mapx)) / 2), 2) +\n" +
            "      COS(RADIANS(mapx)) * COS(RADIANS(?1)) * POWER(SIN((RADIANS(?2) - RADIANS(mapy)) / 2), 2))) <= 2;", nativeQuery = true)
    List<KorServiceInfo> findShoppingPlacesNearby(double mapX, double mapY);

    @Query(value = "SELECT * FROM knto\n" +
            "WHERE contenttypeid = 11 AND \n" +
            "      6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(?1) - RADIANS(mapx)) / 2), 2) +\n" +
            "      COS(RADIANS(mapx)) * COS(RADIANS(?1)) * POWER(SIN((RADIANS(?2) - RADIANS(mapy)) / 2), 2))) <= 2;", nativeQuery = true)
    List<KorServiceInfo> findEnjoyPlacesNearby(double mapX, double mapY);
}