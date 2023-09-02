package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.FindInfo;
import Tour.B_Gosu.Entity.KorServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindRepository extends JpaRepository<FindInfo, Long> {
}