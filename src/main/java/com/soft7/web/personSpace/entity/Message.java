package com.soft7.web.personSpace.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @ClassName message
 * @Description TODO
 * @Author xiaminghui
 * @Date 2019/12/4
 **/
@Data
public class Message {
    private Long id;
    private String name;
    private Date datetime;
    private String content;

    public Message(Long id, String name, Date datetime, String content) {
        this.id = id;
        this.name = name;
        this.datetime = datetime;
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datetime=" + datetime +
                ", content='" + content + '\'' +
                '}';
    }
}