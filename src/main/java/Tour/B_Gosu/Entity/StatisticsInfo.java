package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="statistics")
public class StatisticsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    @Column(name = "top10")
    private int top10;

    @Column(name = "title")
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTop10() {
        return top10;
    }

    public void setTop10(int top10) {
        this.top10 = top10;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
