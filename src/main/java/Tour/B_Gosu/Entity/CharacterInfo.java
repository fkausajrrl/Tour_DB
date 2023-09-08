package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="characters")
public class CharacterInfo {

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;
    @Column(name = "userId")
    private int userId;
    @Column(name = "type")
    private int type;
    @Column(name = "characterName")
    private String characterName;
    @Column(name = "currentMoney")
    private int currentMoney;


}