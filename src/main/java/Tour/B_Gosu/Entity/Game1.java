package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="gaem1")
public class Game1 {

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMaxScore1() {
        return maxScore1;
    }

    public void setMaxScore1(int maxScore1) {
        this.maxScore1 = maxScore1;
    }

    public int getTotalScore1() {
        return totalScore1;
    }

    public void setTotalScore1(int totalScore1) {
        this.totalScore1 = totalScore1;
    }

    public int getTotalMoney1() {
        return totalMoney1;
    }

    public void setTotalMoney1(int totalMoney1) {
        this.totalMoney1 = totalMoney1;
    }

    @Id //pramary key
    @Column(name = "userId")
    private int userId;

    @Column(name = "maxScore1")
    private int maxScore1;

    @Column(name = "totalScore1")
    private int totalScore1;

    @Column(name = "totalMoney1")
    private int totalMoney1;


}
