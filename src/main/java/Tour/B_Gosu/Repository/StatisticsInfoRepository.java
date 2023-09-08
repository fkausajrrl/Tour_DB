package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.StatisticsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsInfoRepository extends JpaRepository<StatisticsInfo, String> {
}
