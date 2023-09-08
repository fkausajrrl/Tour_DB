package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.Game2;
import Tour.B_Gosu.Entity.ItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game2_InfoRepository  extends JpaRepository<Game2, String> {
}
