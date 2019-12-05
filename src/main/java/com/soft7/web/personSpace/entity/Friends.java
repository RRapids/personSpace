package com.soft7.web.personSpace.entity;

import lombok.Data;

/**
 * @ClassName Friends
 * @Description TODO
 * @Author xiaminghui
 * @Date 2019/12/4
 **/
@Data
public class Friends {
    private Integer id;
    private String name;
    private String account;
    private String avatar;

    public Friends(Integer id, String name, String account, String avatar) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}