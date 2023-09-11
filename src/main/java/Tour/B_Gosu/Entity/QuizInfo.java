package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")
public class QuizInfo {
    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "answer")
    private int answer;

}
