package com.soft7.web.personSpace.entity;

public class User {
    private int id;
    private int age;
    private String username;
    private String phonenumber;
    private String gender;
    private int accountnumber;
    private int password;
    private String avatar;

    public User() {
    }

    public User(int id, int age, java.lang.String username, java.lang.String phonenumber, java.lang.String gender, int accountnumber, int password, java.lang.String avatar) {
        this.id = id;
        this.age = age;
        this.username = username;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.accountnumber = accountnumber;
        this.password = password;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", gender='" + gender + '\'' +
                ", accountnumber=" + accountnumber +
                ", password=" + password +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
