package com.soft7.web.personSpace.entity;

import java.util.Date;

public class Photos {
    private Integer id;
    private String photoname;
    private String photodetails;
    private Date createdate;
    private Integer userid;
    private String photoCover;

    public Photos() {
        this.id = id;
        this.photoname = photoname;
        this.photodetails = photodetails;
        this.createdate = createdate;
        this.userid = userid;
        this.photoCover = photoCover;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    public String getPhotodetails() {
        return photodetails;
    }

    public void setPhotodetails(String photodetails) {
        this.photodetails = photodetails;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPhotoCover() {
        return photoCover;
    }

    public void setPhotoCover(String photoCover) {
        this.photoCover = photoCover;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "id=" + id +
                ", photoname='" + photoname + '\'' +
                ", photodetails='" + photodetails + '\'' +
                ", createdate=" + createdate +
                ", userid=" + userid +
                ", photoCover='" + photoCover + '\'' +
                '}';
    }
}
