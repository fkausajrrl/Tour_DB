package Tour.B_Gosu.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name ="myuser")
public class UserInfo {
    //이 Entity는 프론트로부터 받아오는 정보 저장 용도 테이블 설계
    @Id //pramary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //안드로이드 시리얼 넘버의 대조키 -> 별명 같은 개념
    private int userid;

    @Column(name = "android") //안드로이드 시리얼 넘버
    private String android;

    @Column(name = "r_tag3") //한중일양 선택
    private String r_tag3;

    @Column(name = "r_tag4") //맵기 여부
    private String r_tag4;

    @Column(name = "r_tag5") //육류 / 해산물 / 상관없음
    private String r_tag5;

    @Column(name = "r_tag3_1") //식당에서 카페 관련 태그
    private String r_tag3_1;

    @Column(name = "s_tag1") //쇼핑관련 태그
    private String s_tag1;

    @Column(name = "ct_tag4") //자연
    private String ct_tag4;

    @Column(name = "ct_tag2") //역사
    private String ct_tag2;

    @Column(name = "ct_tag3") //체험
    private String ct_tag3;

    @Column(name = "ct_tag1") //동적 / 정적 / 상관없음 알려주는 태그
    private String ct_tag1;

    @Column(name = "user_name") //여행객 이름
    private String user_name;

    @Column(name = "start_date") //여행 시작 날짜
    private String start_date;

    @Column(name = "end_date") //여행 종료 날짜
    private String end_date;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Column(name = "time") //생성 시간
    @CurrentTimestamp
    private Timestamp time;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getR_tag3() {
        return r_tag3;
    }

    public void setR_tag3(String r_tag3) {
        this.r_tag3 = r_tag3;
    }

    public String getR_tag4() {
        return r_tag4;
    }

    public void setR_tag4(String r_tag4) {
        this.r_tag4 = r_tag4;
    }

    public String getR_tag5() {
        return r_tag5;
    }

    public void setR_tag5(String r_tag5) {
        this.r_tag5 = r_tag5;
    }

    public String getR_tag3_1() {
        return r_tag3_1;
    }

    public void setR_tag3_1(String r_tag3_1) {
        this.r_tag3_1 = r_tag3_1;
    }

    public String getS_tag1() {
        return s_tag1;
    }

    public void setS_tag1(String s_tag1) {
        this.s_tag1 = s_tag1;
    }

    public String getCt_tag4() {
        return ct_tag4;
    }

    public void setCt_tag4(String ct_tag4) {
        this.ct_tag4 = ct_tag4;
    }

    public String getCt_tag2() {
        return ct_tag2;
    }

    public void setCt_tag2(String ct_tag2) {
        this.ct_tag2 = ct_tag2;
    }

    public String getCt_tag3() {
        return ct_tag3;
    }

    public void setCt_tag3(String ct_tag3) {
        this.ct_tag3 = ct_tag3;
    }

    public String getCt_tag1() {
        return ct_tag1;
    }

    public void setCt_tag1(String ct_tag1) {
        this.ct_tag1 = ct_tag1;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
