package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="gaem1")
public class Game1 {
    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    public int getMax_score1() {
        return max_score1;
    }

    public void setMax_score1(int max_score1) {
        this.max_score1 = max_score1;
    }

    public int getTotal_score1() {
        return total_score1;
    }

    public void setTotal_score1(int total_score1) {
        this.total_score1 = total_score1;
    }

    public int getTotal_money1() {
        return total_money1;
    }

    public void setTotal_money1(int total_money1) {
        this.total_money1 = total_money1;
    }

    @Id //pramary key
    @Column(name = "characterid")
    private int characterid;

    @Column(name = "max_score1")
    private int max_score1;

    @Column(name = "total_score1")
    private int total_score1;

    @Column(name = "total_money1")
    private int total_money1;

}
