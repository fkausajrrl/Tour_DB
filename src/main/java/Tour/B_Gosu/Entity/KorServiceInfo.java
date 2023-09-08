package Tour.B_Gosu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="knto")
public class KorServiceInfo {
    @Id //pramary key
    @Column(name = "title") //title
    private String title;

    @Column(name = "title_jp") //title_jp
    private String title_jp;

    @Column(name = "title_en") //title_en
    private String title_en;

    @Column(name = "title_ch") //title_ch
    private String title_ch;

    @Column(name = "addr1") //도로명 주소.
    private String addr1;

    @Column(name = "addr2") //지번 주소
    private String addr2;

    @Column(name = "contenttypeid") //음식점(39) / 문화지(14) / 관광지(12) / 쇼핑(38) / 오락(11)
    private String contenttypeid;

    @Column(name = "firstimage") // 이미지 1
    private String firstimage;

    @Column(name = "firstimage2") //이미지 2 => 이미지 1 조금 작아진 버전
    private String firstimage2;

    @Column(name = "mapx") //mapx
    private String mapx;

    @Column(name = "mapy") //mapy
    private String mapy;

    @Column(name = "sigungucode") //시군구 구분 코드
    private String sigungucode;

    @Column(name = "tel") //전화번호.
    private String tel;

    //mydb
    @Column(name = "contants") //챌린지 내용 -> 이 칼럼 비어있으면 (title)가서 (menu)먹어보기
    private String contants;

    @Column(name = "tag1")
    private String tag1;

    @Column(name = "tag2")
    private String tag2;

    @Column(name = "tag3")
    private String tag3;

    @Column(name = "tag4")
    private String tag4;

    @Column(name = "tag5")
    private String tag5;

    @Column(name = "menu") //대표 메뉴
    private String menu;

    @Column(name = "top10") //인기 챌린지 보여주는 용도인데 할려고 할때 활성화 시키면 됨
    private int top10;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_jp() {
        return title_jp;
    }

    public void setTitle_jp(String title_jp) {
        this.title_jp = title_jp;
    }

    public String getTitle_en() {
        return title_en;
    }

    public void setTitle_en(String title_en) {
        this.title_en = title_en;
    }

    public String getTitle_ch() {
        return title_ch;
    }

    public void setTitle_ch(String title_ch) {
        this.title_ch = title_ch;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(String contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getFirstimage2() {
        return firstimage2;
    }

    public void setFirstimage2(String firstimage2) {
        this.firstimage2 = firstimage2;
    }

    public String getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = mapx;
    }

    public String getMapy() {
        return mapy;
    }

    public void setMapy(String mapy) {
        this.mapy = mapy;
    }

    public String getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(String sigungucode) {
        this.sigungucode = sigungucode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getContants() {
        return contants;
    }

    public void setContants(String contants) {
        this.contants = contants;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getTag4() {
        return tag4;
    }

    public void setTag4(String tag4) {
        this.tag4 = tag4;
    }

    public String getTag5() {
        return tag5;
    }

    public void setTag5(String tag5) {
        this.tag5 = tag5;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getTop10() {
        return top10;
    }

    public void setTop10(int top10) {
        this.top10 = top10;
    }
}