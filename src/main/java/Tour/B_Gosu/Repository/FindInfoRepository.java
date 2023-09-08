package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.FindInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FindInfoRepository extends JpaRepository<FindInfo, String> {
}
