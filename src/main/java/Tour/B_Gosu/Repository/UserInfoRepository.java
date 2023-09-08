package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    @Query(value = "SELECT * FROM users\n" +
            "WHERE userId = :numbers AND \n" +
            "      StartDate = :sDate", nativeQuery = true)
    Optional<UserInfo>  findMyuser(String numbers, String sDate);

    Optional<UserInfo> findByUserId(int userId);
}
