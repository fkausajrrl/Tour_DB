package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Success")
public class SuccessInfo {

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;
    @Column(name = "userId")
    private int userId;

    @Column(name = "title")
    private String title;


}
