package Tour.B_Gosu.Repository;

import Tour.B_Gosu.Entity.QuizInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizInfoRepository extends JpaRepository<QuizInfo, String> {

}
