package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="myuser")
public class UserInfo {
    //이 Entity는 프론트로부터 받아오는 정보 저장 용도 테이블 설계
    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //안드로이드 시리얼 넘버의 대조키 -> 별명 같은 개념
    private int userId;

    @Column(name = "android") //안드로이드 시리얼 넘버
    private String android;

    @Column(name = "Rtag3") //한중일양 선택
    private String Rtag3;

    @Column(name = "Rtag4") //맵기 여부
    private String Rtag4;

    @Column(name = "Rtag5") //육류 / 해산물 / 상관없음
    private String Rtag5;

    @Column(name = "Rtag3Cafe") //식당에서 카페 관련 태그
    private String Rtag3Cafe;

    @Column(name = "Stag1") //쇼핑관련 태그
    private String Stag1;

    @Column(name = "CTtag4") //자연
    private String CTtag4;

    @Column(name = "CTtag2") //역사
    private String CTtag2;

    @Column(name = "CTtag3") //체험
    private String CTtag3;

    @Column(name = "CTtag1") //동적 / 정적 / 상관없음 알려주는 태그
    private String CTtag1;

    @Column(name = "userName") //여행객 이름
    private String userName;

    @Column(name = "startDate") //여행 시작 날짜
    private String startDate;

    @Column(name = "endDate") //여행 종료 날짜
    private String endDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getRtag3() {
        return Rtag3;
    }

    public void setRtag3(String rtag3) {
        Rtag3 = rtag3;
    }

    public String getRtag4() {
        return Rtag4;
    }

    public void setRtag4(String rtag4) {
        Rtag4 = rtag4;
    }

    public String getRtag5() {
        return Rtag5;
    }

    public void setRtag5(String rtag5) {
        Rtag5 = rtag5;
    }

    public String getRtag3Cafe() {
        return Rtag3Cafe;
    }

    public void setRtag3Cafe(String rtag3Cafe) {
        Rtag3Cafe = rtag3Cafe;
    }

    public String getStag1() {
        return Stag1;
    }

    public void setStag1(String stag1) {
        Stag1 = stag1;
    }

    public String getCTtag4() {
        return CTtag4;
    }

    public void setCTtag4(String CTtag4) {
        this.CTtag4 = CTtag4;
    }

    public String getCTtag2() {
        return CTtag2;
    }

    public void setCTtag2(String CTtag2) {
        this.CTtag2 = CTtag2;
    }

    public String getCTtag3() {
        return CTtag3;
    }

    public void setCTtag3(String CTtag3) {
        this.CTtag3 = CTtag3;
    }

    public String getCTtag1() {
        return CTtag1;
    }

    public void setCTtag1(String CTtag1) {
        this.CTtag1 = CTtag1;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
