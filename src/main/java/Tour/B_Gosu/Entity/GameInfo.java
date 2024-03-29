package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GameInfo {
    @Id
    private int characterid;
    @Column(name = "head_fir") // 모자
    private int head_fir;
    @Column(name = "head_sec") // 쟁반 모자
    private int head_sec;
    @Column(name = "head_thr") // 안경
    private int head_thr;
    @Column(name = "neck_fir") // 넥타이 - 빨간
    private int neck_fir;
    @Column(name = "neck_sec") // 넥타이 - 흰색
    private int neck_sec;
    @Column(name = "hand_fir") // 칼
    private int hand_fir;
    @Column(name = "hand_sec") //핸드백
    private int hand_sec;
    @Column(name = "end_date") //여행 종료 날짜
    private String end_date;
    @Column(name = "max_score1")
    private int max_score1;
    @Column(name = "max_score2")
    private int max_score2;
    @Column(name = "type")
    private int type;
    @Column(name = "character_name")
    private String character_name;
    @Column(name = "current_money")
    private int current_money;
    @Column(name = "user_name")
    private String user_name;

    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    public int getHead_fir() {
        return head_fir;
    }

    public void setHead_fir(int head_fir) {
        this.head_fir = head_fir;
    }

    public int getHead_sec() {
        return head_sec;
    }

    public void setHead_sec(int head_sec) {
        this.head_sec = head_sec;
    }

    public int getHead_thr() {
        return head_thr;
    }

    public void setHead_thr(int head_thr) {
        this.head_thr = head_thr;
    }

    public int getNeck_fir() {
        return neck_fir;
    }

    public void setNeck_fir(int neck_fir) {
        this.neck_fir = neck_fir;
    }

    public int getNeck_sec() {
        return neck_sec;
    }

    public void setNeck_sec(int neck_sec) {
        this.neck_sec = neck_sec;
    }

    public int getHand_fir() {
        return hand_fir;
    }

    public void setHand_fir(int hand_fir) {
        this.hand_fir = hand_fir;
    }

    public int getHand_sec() {
        return hand_sec;
    }

    public void setHand_sec(int hand_sec) {
        this.hand_sec = hand_sec;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getMax_score1() {
        return max_score1;
    }

    public void setMax_score1(int max_score1) {
        this.max_score1 = max_score1;
    }
    public int getMax_score2() {
        return max_score2;
    }

    public void setMax_score2(int max_score2) {
        this.max_score2 = max_score2;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
