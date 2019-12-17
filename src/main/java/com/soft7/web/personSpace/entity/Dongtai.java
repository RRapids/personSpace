package com.soft7.web.personSpace.entity;

import java.util.Date;

/**
 * @Classname Dongtai
 * @Description TODO
 * @Date 2019/12/13 9:51
 * @Created by tf_yuan
 */
public class Dongtai {
    private Integer id;
    private String username;
    private String avatar;
    private String content;
    private String contentImg;
    private Date date;

    public Dongtai() {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.content = content;
        this.contentImg = contentImg;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentImg() {
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dongtai{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", contentImg='" + contentImg + '\'' +
                ", date=" + date +
                '}';
    }
}
