package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

}
