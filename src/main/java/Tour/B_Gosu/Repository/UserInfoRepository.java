package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
//    Optional<UserInfo> findByAndroid(String android);
}
