package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.KorServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorServiceInfoRepository extends JpaRepository<KorServiceInfo, String> {
}