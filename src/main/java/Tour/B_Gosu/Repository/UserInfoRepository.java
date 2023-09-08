package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    @Query(value = "SELECT * FROM myuser\n" +
            "WHERE android = :numbers AND\n" +
            "start_date =:s_date", nativeQuery = true)
    Optional<UserInfo> findMyuser(String numbers, String s_date);

    Optional<UserInfo> findByUserid(int userid);

    Optional<UserInfo> findByAndroid(String android);
}
