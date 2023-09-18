package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.DailyArCoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DailyArCoreInfoRepository extends JpaRepository<DailyArCoreInfo, String> {
    DailyArCoreInfo findByCharacterid(int characterid);

}
