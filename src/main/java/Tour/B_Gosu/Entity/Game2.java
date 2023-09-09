package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="game2")
public class Game2 {

    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    public int getMax_score2() {
        return max_score2;
    }

    public void setMax_score2(int max_score2) {
        this.max_score2 = max_score2;
    }

    public int getTotal_score2() {
        return total_score2;
    }

    public void setTotal_score2(int total_score2) {
        this.total_score2 = total_score2;
    }

    public int getTotal_money2() {
        return total_money2;
    }

    public void setTotal_money2(int total_money2) {
        this.total_money2 = total_money2;
    }

    @Id //pramary key
    @Column(name = "characterid")
    private int characterid;

    @Column(name = "max_score2")
    private int max_score2;

    @Column(name = "total_score2")
    private int total_score2;

    @Column(name = "total_money2")
    private int total_money2;
}
