package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;

@Entity
@Table(name = "arcore")
@Getter
@Setter
public class DailyArCoreInfo {
    @Id
    @Column(name = "characterid")
    int characterid;

    @Column(name = "su") //오늘 사진 찍었는지 여부
    int su;
}
