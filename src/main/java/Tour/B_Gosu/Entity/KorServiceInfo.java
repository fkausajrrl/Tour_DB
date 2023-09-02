package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="knto2")
public class KorServiceInfo {
<<<<<<< Updated upstream
=======

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(String character_id) {
        this.character_id = character_id;
    }

    @Column(name = "fix")
    private String fix;

    @Column(name = "character_id")
    private String character_id;
    @Override
    public String toString() {
        // 원하는 형식으로 객체 정보를 반환하도록 구현
        return "KorServiceInfo{" +
                "title='" + title + "'" + "\n" +
                "addr1 = '" + addr1 + "'" +"}"; //post 매핑 확인용
    }
        @Id //pramary key
    @Column(name = "title")
    private String title;

    @Column(name = "title_jp")
    private String title_jp;

    @Column(name = "title_en")
    private String title_en;

    @Column(name = "title_ch")
    private String title_ch;

>>>>>>> Stashed changes
    @Column(name = "addr1")
    private String addr1;

    @Column(name = "addr2")
    private String addr2;

//    @Column(name = "areacode")
//    private String areacode;
//
//    @Column(name = "booktour")
//    private String booktour;
//
//    @Column(name = "cat1")
//    private String cat1;
//
//    @Column(name = "cat2")
//    private String cat2;
//
//    @Column(name = "cat3")
//    private String cat3;
//
//    @Column(name = "contentid")
//    private String contentid;

    @Column(name = "contenttypeid")
    private String contenttypeid;
//
//    @Column(name = "createdtime")
//    private String createdtime;

    @Column(name = "firstimage")
    private String firstimage;

    @Column(name = "firstimage2")
    private String firstimage2;

//    @Column(name = "cpyrhtDivCd")
//    private String cpyrhtDivCd;

    @Column(name = "mapx")
    private String mapx;

    @Column(name = "mapy")
    private String mapy;
<<<<<<< Updated upstream
=======

    @Column(name = "sigungucode")
    private String sigungucode;

    @Column(name = "tel")
    private String tel;

    //mydb

    @Column(name = "contants")
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

    @Column(name = "menu")
    private String menu;


//
//    @Column(name = "contentid")
//    private String contentid;
//
//    @Column(name = "createdtime")
//    private String createdtime;
//    @Column(name = "cpyrhtDivCd")
//    private String cpyrhtDivCd;
>>>>>>> Stashed changes
//
//    @Column(name = "mlevel")
//    private String mlevel;
//
//    @Column(name = "modifiedtime")
//    private String modifiedtime;
//
    @Column(name = "sigungucode")
    private String sigungucode;

    @Column(name = "tel")
    private String tel;

    @Id //pramary key
    @Column(name = "title")
    private String title;

//    @Column(name = "zipcode")
//    private String zipcode;

    //getter/setter methods
<<<<<<< Updated upstream
=======
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

>>>>>>> Stashed changes
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

//    public String getAreacode() {
//        return areacode;
//    }
//
//    public void setAreacode(String areacode) {
//        this.areacode = areacode;
//    }
//
//    public String getBooktour() {
//        return booktour;
//    }
//
//    public void setBooktour(String booktour) {
//        this.booktour = booktour;
//    }

//    public String getCat1() {
//        return cat1;
//    }
//
//    public void setCat1(String cat1) {
//        this.cat1 = cat1;
//    }
//
//    public String getCat2() {
//        return cat2;
//    }
//
//    public void setCat2(String cat2) {
//        this.cat2 = cat2;
//    }
//
//    public String getCat3() {
//        return cat3;
//    }
//
//    public void setCat3(String cat3) {
//        this.cat3 = cat3;
//    }
//
//    public String getContentid() {
//        return contentid;
//    }
//
//    public void setContentid(String contentid) {
//        this.contentid = contentid;
//    }

    public String getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(String contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

//    public String getCreatedtime() {
//        return createdtime;
//    }
//
//    public void setCreatedtime(String createdtime) {
//        this.createdtime = createdtime;
//    }

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

//    public String getCpyrhtDivCd() {
//        return cpyrhtDivCd;
//    }
//
//    public void setCpyrhtDivCd(String cpyrhtDivCd) {
//        this.cpyrhtDivCd = cpyrhtDivCd;
//    }

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
//
//    public String getMlevel() {
//        return mlevel;
//    }
//
//    public void setMlevel(String mlevel) {
//        this.mlevel = mlevel;
//    }
//
//    public String getModifiedtime() {
//        return modifiedtime;
//    }
//
//    public void setModifiedtime(String modifiedtime) {
//        this.modifiedtime = modifiedtime;
//    }
//
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

<<<<<<< Updated upstream
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
=======
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
>>>>>>> Stashed changes
}