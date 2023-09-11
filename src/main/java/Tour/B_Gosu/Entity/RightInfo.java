package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CurrentTimestamp;

@Entity
public class RightInfo {
    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public int getSuccess_count() {
        return success_count;
    }

    public void setSuccess_count(int success_count) {
        this.success_count = success_count;
    }

    public String getSuccess_area() {
        return success_area;
    }

    public void setSuccess_area(String success_area) {
        this.success_area = success_area;
    }

    public int getTotal_score1() {
        return total_score1;
    }

    public void setTotal_score1(int total_score1) {
        this.total_score1 = total_score1;
    }

    public int getTotal_score2() {
        return total_score2;
    }

    public void setTotal_score2(int total_score2) {
        this.total_score2 = total_score2;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    @Id
    @Column(name = "characterid")  //프론트에서 받기
    private int characterid;

    @Column(name = "times")  //캐릭터와 함께한 시간 -> api 요청 들어오면 요청 들어온 시간 기록해서 db에 저장된 캐릭터 생성 시간과 비교해서 반환.
    private String times;

    @Column(name = "success_count")  //완료한 챌린지 갯수 ->success 테이블에서 count 가져오기
    private int success_count;

    @Column(name = "success_area") //success 테이블에 성공한 챌린지 시군구 코드까지 추가해야됨. -> 그리고 숫자로 된걸 검색해서 처리해서 보여주기
    private String success_area; // 챌린지 한 동네 갯수 or 챌린지 한 동네 이름 => 동네 이름

    @Column(name = "total_score1") //게임 1 총 스코어  -> game2 테이블에서 total_score1 가져오기
    private int total_score1;

    @Column(name = "total_score2") //게임 2 총 스코어  -> game2 테이블에서 total_score2 가져오기
    private int total_score2;

    @Column(name = "total_money") //총 재화   -> characters 테이블에서 total_money 가져오기
    private int total_money;
}
