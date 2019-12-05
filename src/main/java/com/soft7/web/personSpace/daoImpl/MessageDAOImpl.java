package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.MessageDAO;
import com.soft7.web.personSpace.entity.Message;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Classname MessageDAOImpl
 * @Description TODO
 * @Date 2019/12/4 10:44
 * @Created by tf_yuan
 */
public class MessageDAOImpl implements MessageDAO {
    @Override
    public int insertMessages(Message message) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_message(name,content,datatime) VALUES (?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1,message.getName());
        pstmt.setString(2,message.getContent());
        pstmt.setDate(3,new Date(message.getDatetime().getTime()));
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deleteMessagesById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_message where id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }
}
