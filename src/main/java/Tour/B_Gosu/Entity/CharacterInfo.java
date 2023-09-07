package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="characters")
public class CharacterInfo {

    @Id //pramary key
    @Column(name = "answer_id")
    private String answer_id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "max_score1")
    private String max_score1;
    @Column(name = "max_score2")
    private String max_score2;
    @Column(name = "total_score1")
    private String total_score1;
    @Column(name = "total_score2")
    private String total_score2;
    @Column(name = "complete")
    private String complete;
    @Column(name = "total_money")
    private String total_money;

    public String getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMax_score1() {
        return max_score1;
    }

    public void setMax_score1(String max_score1) {
        this.max_score1 = max_score1;
    }

    public String getMax_score2() {
        return max_score2;
    }

    public void setMax_score2(String max_score2) {
        this.max_score2 = max_score2;
    }

    public String getTotal_score1() {
        return total_score1;
    }

    public void setTotal_score1(String total_score1) {
        this.total_score1 = total_score1;
    }

    public String getTotal_score2() {
        return total_score2;
    }

    public void setTotal_score2(String total_score2) {
        this.total_score2 = total_score2;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }
}