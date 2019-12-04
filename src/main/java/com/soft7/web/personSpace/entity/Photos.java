package com.soft7.web.personSpace.entity;

import java.util.Date;

public class Photos {
    private Integer id;
    private String photoname;
    private String photodetails;
    private Date createdate;
    private Integer userid;

    public Photos() {
    }

    public Photos(int id, String photoname, String photodetails, Date createdate, int userid) {
        this.id = id;
        this.photoname = photoname;
        this.photodetails = photodetails;
        this.createdate = createdate;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "id=" + id +
                ", photoname='" + photoname + '\'' +
                ", photodetails='" + photodetails + '\'' +
                ", createdate=" + createdate +
                ", userid=" + userid +
                '}';
    }
}
