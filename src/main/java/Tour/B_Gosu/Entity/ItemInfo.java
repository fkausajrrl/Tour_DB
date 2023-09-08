package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="item")
public class ItemInfo {
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHeadFir() {
        return headFir;
    }

    public void setHeadFir(int headFir) {
        this.headFir = headFir;
    }

    public int getHeadSec() {
        return headSec;
    }

    public void setHeadSec(int headSec) {
        this.headSec = headSec;
    }

    public int getHeadThr() {
        return headThr;
    }

    public void setHeadThr(int headThr) {
        this.headThr = headThr;
    }

    public int getNeckFir() {
        return neckFir;
    }

    public void setNeckFir(int neckFir) {
        this.neckFir = neckFir;
    }

    public int getNeckSec() {
        return neckSec;
    }

    public void setNeckSec(int neckSec) {
        this.neckSec = neckSec;
    }

    public int getHandFir() {
        return handFir;
    }

    public void setHandFir(int handFir) {
        this.handFir = handFir;
    }

    public int getHandSec() {
        return handSec;
    }

    public void setHandSec(int handSec) {
        this.handSec = handSec;
    }

    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(name = "userId") // 모자
    private int userId;
    @Column(name = "headFir") // 모자
    private int headFir;
    @Column(name = "headSec") // 쟁반 모자
    private int headSec;
    @Column(name = "headThr") // 안경
    private int headThr;
    @Column(name = "neckFir") // 넥타이 - 빨간
    private int neckFir;
    @Column(name = "neckSec") // 넥타이 - 흰색
    private int neckSec;
    @Column(name = "handFir") // 칼
    private int handFir;
    @Column(name = "handSec") //핸드백
    private int handSec;


}
