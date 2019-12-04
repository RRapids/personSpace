package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Message;

import java.sql.SQLException;

/**
 * @Classname MessageDAO
 * @Description TODO
 * @Date 2019/12/4 9:10
 * @Created by tf_yuan
 */
public interface MessageDAO {
    //新增留言
    int insertMessages(Message message) throws SQLException;
    //删除留言
    int deleteMessagesById(int id) throws SQLException;

}
