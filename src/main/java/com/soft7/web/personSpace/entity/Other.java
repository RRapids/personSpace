package com.soft7.web.personSpace.entity;

/**
 * @Classname Other
 * @Description TODO
 * @Date 2019/12/15 15:28
 * @Created by tf_yuan
 */
public class Other {
    private Integer id;
    private String name;
    private String account;
    private String avatar;

    public Other() {
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
        return "Other{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
