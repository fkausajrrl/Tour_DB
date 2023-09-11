package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Success")
public class SuccessInfo {

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(String sigungucode) {
        this.sigungucode = sigungucode;
    }

    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    @Column(name = "characterid")
    private int characterid;

    @Column(name = "title")
    private String title;

    @Column(name = "sigungucode")
    private String sigungucode;


}
