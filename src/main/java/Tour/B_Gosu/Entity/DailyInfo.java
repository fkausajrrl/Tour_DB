package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "daily")
public class DailyInfo {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDaily_quiz() {
        return daily_quiz;
    }

    public void setDaily_quiz(String daily_quiz) {
        this.daily_quiz = daily_quiz;
    }

    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int count; //index

    @Column(name = "daily_quiz") //아시나요~!를 저장
    private String daily_quiz;
}
