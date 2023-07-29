package Tour.B_Gosu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="food_kr_final")
public class KorServiceInfo {
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
//
//    @Column(name = "mlevel")
//    private String mlevel;
//
//    @Column(name = "modifiedtime")
//    private String modifiedtime;
//
//    @Column(name = "sigungucode")
//    private String sigungucode;

    @Column(name = "tel")
    private String tel;

    @Id //pramary key
    @Column(name = "title")
    private String title;

//    @Column(name = "zipcode")
//    private String zipcode;

    //getter/setter methods
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
//    public String getSigungucode() {
//        return sigungucode;
//    }
//
//    public void setSigungucode(String sigungucode) {
//        this.sigungucode = sigungucode;
//    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

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
}