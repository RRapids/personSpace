package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.LogDAO;
import com.soft7.web.personSpace.entity.Logs;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            logs.setName(rs.getString("name"));
            logs.setContent(rs.getString("content"));
            logs.setLogDate(rs.getDate("datatime"));
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
        String sql = "INSERT INTO t_log(name,content,datatime) VALUES (?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, logs.getName());
        pstmt.setString(2, logs.getContent());
        pstmt.setDate(3, new Date(logs.getLogDate().getTime()));
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deleteLogsById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_log WHERE id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public List<Logs> selectLogsLike(String keywords) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_log WHERE name LIKE ?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, "%" + keywords + "%");
        ResultSet rs = pstmt.executeQuery();
        List<Logs> logsList = new ArrayList<>();
        while (rs.next()) {
            Logs logs = new Logs();
            logs.setId(rs.getInt("id"));
            logs.setName(rs.getString("name"));
            logs.setContent(rs.getString("content"));
            logs.setLogDate(rs.getDate("datatime"));
            logsList.add(logs);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return logsList;
    }
}
