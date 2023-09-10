package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.DailyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyInfoRepository extends JpaRepository<DailyInfo, String> {
    DailyInfo findByCount(int type);
}
