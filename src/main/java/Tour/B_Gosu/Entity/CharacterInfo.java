package Tour.B_Gosu.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "characters")
public class CharacterInfo {

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public int getCurrent_money() {
        return current_money;
    }

    public void setCurrent_money(int current_money) {
        this.current_money = current_money;
    }

    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }
    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    public int getSuccess_count() {
        return success_count;
    }

    public void setSuccess_count(int success_count) {
        this.success_count = success_count;
    }


    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterid;
    @Column(name = "userid")
    private int userid;
    @Column(name = "type")
    private int type;
    @Column(name = "character_name")
    private String character_name;
    @Column(name = "current_money")
    private int current_money;
    @Column(name = "total_money")
    private int total_money;
    @Column(name = "time") //생성 시간
    @CurrentTimestamp
    private Timestamp time;

    @Column(name = "success_count")
    private int success_count;
}