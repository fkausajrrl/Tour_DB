package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Success")
public class SuccessInfo {
    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;
    @Column(name = "answer_id")
    private String answer_id;

    @Column(name = "title")
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
