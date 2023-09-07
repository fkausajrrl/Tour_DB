package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="characters")
public class CharacterInfo {
    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "type")
    private int type;
    @Column(name = "character_name")
    private String character_name;
    @Column(name = "current_money")
    private int current_money;

    public int getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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


}