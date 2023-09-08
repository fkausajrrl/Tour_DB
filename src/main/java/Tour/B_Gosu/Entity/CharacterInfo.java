package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

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


}