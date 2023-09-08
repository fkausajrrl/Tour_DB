package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="game2")
public class Game2 {

    @Id //pramary key
    @Column(name = "userId")
    private int userId;

    @Column(name = "maxScore2")
    private int maxScore2;

    @Column(name = "totalScore2")
    private int totalScore2;

    @Column(name = "totalMoney2")
    private int totalMoney2;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMaxScore2() {
        return maxScore2;
    }

    public void setMaxScore2(int maxScore2) {
        this.maxScore2 = maxScore2;
    }

    public int getTotalScore2() {
        return totalScore2;
    }

    public void setTotalScore2(int totalScore2) {
        this.totalScore2 = totalScore2;
    }

    public int getTotalMoney2() {
        return totalMoney2;
    }

    public void setTotalMoney2(int totalMoney2) {
        this.totalMoney2 = totalMoney2;
    }
}
