package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")
public class QuizInfo {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuiz_problem() {
        return quiz_problem;
    }

    public void setQuiz_problem(String quiz_problem) {
        this.quiz_problem = quiz_problem;
    }

    public int getQuiz_answer() {
        return quiz_answer;
    }

    public void setQuiz_answer(int quiz_answer) {
        this.quiz_answer = quiz_answer;
    }

    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "quiz_problem")
    private String quiz_problem;

    @Column(name = "quiz_answer")
    private int quiz_answer;

}
