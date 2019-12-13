package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.MessageDAO;
import com.soft7.web.personSpace.entity.Message;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname MessageDAOImplTest
 * @Description TODO
 * @Date 2019/12/5 8:36
 * @Created by tf_yuan
 */
public class MessageDAOImplTest {
    private MessageDAO messageDAO = DaoFactory.getMessageDAOInstance();

    @Test
    public void insertMessages(){
        Message message = new Message();
        message.setName("奥给");
        message.setContent("点反对");
        message.setDatetime(new Date());
        int n = 0;
        try {
            n = messageDAO.insertMessages(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }

    @Test
    public void deleteMessagesById() {
    }

    @Test
    public void selectAllMessages() {
        List<Message> messageList = null;
        try {
            messageList = messageDAO.selectAllMessages();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        messageList.forEach(message -> System.out.println(message));
    }
}