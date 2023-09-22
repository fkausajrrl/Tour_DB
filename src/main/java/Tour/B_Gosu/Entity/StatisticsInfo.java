package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="statistics")
public class StatisticsInfo implements Comparable<StatisticsInfo>{
//    @Override
//    public int compareTo(StatisticsInfo other) {
//        // top10 값을 비교하여 내림차순으로 정렬
//        return Integer.compare(other.getTop10(), this.top10);
//    }

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    @Column(name = "top10")
    private int top10;

    @Column(name = "title")
    private String title;

    @Override
    public int compareTo(StatisticsInfo other) {
        // top10 값을 비교하여 내림차순으로 정렬
        return Integer.compare(other.getTop10(), this.top10);
    }
}
