package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.MessageDAO;
import com.soft7.web.personSpace.entity.Message;
import com.soft7.web.personSpace.util.DataBaseConnection;
import com.soft7.web.personSpace.util.SplitPage;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname MessageDAOImpl
 * @Description TODO
 * @Date 2019/12/4 10:44
 * @Created by tf_yuan
 */
public class MessageDAOImpl implements MessageDAO {
    @Override
    public List<Message> selectAllMessages() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_message";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Message> messageList = new ArrayList<>();
        while (rs.next()){
            Message message = new Message();
            message.setId(rs.getInt("id"));
            message.setName(rs.getString("name"));
            message.setContent(rs.getString("content"));
            message.setDatetime(rs.getDate("datetime"));
            messageList.add(message);
        }
        dbc.close();
        rs.close();
        pstmt.close();
        return messageList;
    }

    @Override
    public int insertMessages(Message message) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_message(name,content,datetime) VALUES (?,?,?)";
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
        String sql = "DELETE FROM t_message WHERE id= " + id;
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int getRows(HashMap tm) throws Exception {
        List<Message> list = null;
        if (tm.isEmpty()) {
            list = selectAllMessages();
        }
        int num = list.size();
        return num;
    }

    @Override
    public List<Message> findAll(SplitPage sp) throws Exception {
        List<Message> list = new ArrayList<Message>();
        String sql = "select * from t_message order by id desc limit " + sp.getPageRows() * (sp.getCurrentPage() - 1) + "," + sp.getPageRows();
        DataBaseConnection dbc = new DataBaseConnection();
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Message message = new Message();
            message.setId(rs.getInt(1));
            message.setName(rs.getString(2));
            message.setContent(rs.getString(3));
            message.setDatetime(rs.getDate(4));
            list.add(message);
        }
        dbc.close();
        pstmt.close();
        rs.close();
        return list;
    }
}
