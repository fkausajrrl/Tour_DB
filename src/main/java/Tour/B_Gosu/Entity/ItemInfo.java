package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="item")
public class ItemInfo {
    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_id;
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

    public int getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
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

}
