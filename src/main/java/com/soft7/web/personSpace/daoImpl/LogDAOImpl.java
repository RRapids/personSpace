package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.LogDAO;
import com.soft7.web.personSpace.entity.Logs;
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
 * @Classname LogDAOImpl
 * @Description TODO
 * @Date 2019/12/4 10:44
 * @Created by tf_yuan
 */
public class LogDAOImpl implements LogDAO {

    @Override
    public List<Logs> selectAllLogs() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_log";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Logs> logsList = new ArrayList<>();
        while (rs.next()) {
            Logs logs = new Logs();
            logs.setId(rs.getInt("id"));
            logs.setName(rs.getString("username"));
            logs.setTitle(rs.getString("t_title"));
            logs.setContent(rs.getString("content"));
            logs.setLogDate(rs.getDate("log_date"));
            logsList.add(logs);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return logsList;
    }

    @Override
    public int insertLogs(Logs logs) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_log(username,t_title,content,log_date) VALUES (?,?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, logs.getName());
        pstmt.setString(2, logs.getTitle());
        pstmt.setString(3, logs.getContent());
        pstmt.setDate(4, new Date(logs.getLogDate().getTime()));
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public Logs readLogById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_log where id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Logs logs = new Logs();
        while (rs.next()){
            logs.setId(rs.getInt("id"));
            logs.setName(rs.getString("username"));
            logs.setTitle(rs.getString("t_title"));
            logs.setContent(rs.getString("content"));
            logs.setLogDate(rs.getDate("log_date"));
        }
        return logs;
    }

    @Override
    public int deleteLogsById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "DELETE FROM t_log WHERE id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public List<Logs> selectLogsLike(String keywords) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_log WHERE t_title LIKE ?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, "%" + keywords + "%");
        ResultSet rs = pstmt.executeQuery();
        List<Logs> logsList = new ArrayList<>();
        while (rs.next()) {
            Logs logs = new Logs();
            logs.setId(rs.getInt("id"));
            logs.setName(rs.getString("username"));
            logs.setTitle(rs.getString("t_title"));
            logs.setContent(rs.getString("content"));
            logs.setLogDate(rs.getDate("log_date"));
            logsList.add(logs);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return logsList;
    }
}
