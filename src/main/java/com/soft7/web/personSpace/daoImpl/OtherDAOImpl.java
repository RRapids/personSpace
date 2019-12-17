package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.OtherDAO;
import com.soft7.web.personSpace.entity.Other;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname OtherDAOImpl
 * @Description TODO
 * @Date 2019/12/15 15:29
 * @Created by tf_yuan
 */
public class OtherDAOImpl implements OtherDAO {
    @Override
    public Other getOtherById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_other where id = ?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Other other = new Other();
        while (rs.next()) {
            Integer friendsId = rs.getInt("id");
            String name = rs.getString("name");
            String account = rs.getString("account");
            String avatar = rs.getString("avatar");
            other.setId(friendsId);
            other.setName(name);
            other.setAccount(account);
            other.setAvatar(avatar);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return other;
    }

    @Override
    public List<Other> getAllOther() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_other";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Other> otherList = new ArrayList<>();
        while (rs.next()) {
            Other other = new Other();
            other.setId(rs.getInt("id"));
            other.setAccount(rs.getString("account"));
            other.setName(rs.getString("name"));
            other.setAvatar(rs.getString("avatar"));
            otherList.add(other);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return otherList;
    }

    @Override
    public Other getOtherByAccount(String account) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_other where account = ?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        Other other = new Other();
        while (rs.next()) {
            Integer friendsId = rs.getInt("id");
            String name = rs.getString("name");
            String t_account = rs.getString("account");
            String avatar = rs.getString("avatar");
            other.setId(friendsId);
            other.setName(name);
            other.setAccount(t_account);
            other.setAvatar(avatar);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return other;
    }
}
