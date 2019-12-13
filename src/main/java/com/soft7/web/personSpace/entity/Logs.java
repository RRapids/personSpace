package com.soft7.web.personSpace.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName log
 * @Description TODO
 * @Author xiaminghui
 * @Date 2019/12/4
 **/
@Data
public class Logs {
    private Integer id;
    private String name;
    private String title;
    private String content;
    private Date logDate;

    public Logs() {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.logDate = logDate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", logDate=" + logDate +
                '}';
    }
}