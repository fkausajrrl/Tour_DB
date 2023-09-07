package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    Optional<UserInfo> findByAndroidId(String androidId);
}
