package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Success")
public class SuccessInfo {
    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;
    @Column(name = "character_id")
    private int character_id;

    @Column(name = "title")
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
