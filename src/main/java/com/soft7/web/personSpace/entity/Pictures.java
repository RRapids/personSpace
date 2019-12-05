package com.soft7.web.personSpace.entity;

import java.util.Date;

public class Pictures {
    private Integer id;
    private String picturename;
    private String picture;
    private Integer photoid;
    private String picturesdetails;
    private Date update;
    private Integer userid;

    public Pictures(){

    }

    public Pictures(int id, String picturename, String picture, int photoid, String picturesdetails, Date update, int userid) {
        this.id = id;
        this.picturename = picturename;
        this.picture = picture;
        this.photoid = photoid;
        this.picturesdetails = picturesdetails;
        this.update = update;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }

    public String getPicturesdetails() {
        return picturesdetails;
    }

    public void setPicturesdetails(String picturesdetails) {
        this.picturesdetails = picturesdetails;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
