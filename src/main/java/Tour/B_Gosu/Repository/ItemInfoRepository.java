package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.ItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInfoRepository extends JpaRepository<ItemInfo, String> {
}
