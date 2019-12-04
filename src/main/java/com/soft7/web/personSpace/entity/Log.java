package com.soft7.web.personSpace.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @ClassName log
 * @Description TODO
 * @Author xiaminghui
 * @Date 2019/12/4
 **/
@Data
public class Log {
    private Long id;
    private String name;
    private Date logDate;
    private String content;

    public Log(Long id, String name, Date logDate, String content) {
        this.id = id;
        this.name = name;
        this.logDate = logDate;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logDate=" + logDate +
                ", content='" + content + '\'' +
                '}';
    }
}