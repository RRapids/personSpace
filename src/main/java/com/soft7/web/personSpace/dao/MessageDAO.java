package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Logs;
import com.soft7.web.personSpace.entity.Message;
import com.soft7.web.personSpace.util.SplitPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname MessageDAO
 * @Description TODO
 * @Date 2019/12/4 9:10
 * @Created by tf_yuan
 */
public interface MessageDAO {
    //获取全部留言
    List<Message> selectAllMessages() throws SQLException;
    //新增留言
    int insertMessages(Message message) throws SQLException;
    //删除留言
    int deleteMessagesById(int id) throws SQLException;
    //
    public int getRows(HashMap tm) throws Exception;
    //
    public List<Message> findAll(SplitPage sp)throws Exception;


}
