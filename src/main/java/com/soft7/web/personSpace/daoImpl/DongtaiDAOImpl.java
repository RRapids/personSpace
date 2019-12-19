package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.DongtaiDAO;
import com.soft7.web.personSpace.entity.Dongtai;
import com.soft7.web.personSpace.entity.Message;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DongtaiDAOImpl
 * @Description TODO
 * @Date 2019/12/13 9:54
 * @Created by tf_yuan
 */
public class DongtaiDAOImpl implements DongtaiDAO {
    @Override
    public List<Dongtai> selectAllDongtai() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_dongtai ORDER BY id DESC";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Dongtai> dongtaiList = new ArrayList<>();
        while (rs.next()){
            Dongtai dongtai = new Dongtai();
            dongtai.setId(rs.getInt("id"));
            dongtai.setContent(rs.getString("content"));
            dongtai.setContentImg(rs.getString("content_img"));
            dongtai.setDate(rs.getDate("date"));
            dongtaiList.add(dongtai);
        }
        dbc.close();
        rs.close();
        pstmt.close();
        return dongtaiList;
    }

    @Override
    public int insertDontai(Dongtai dongtai) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_dongtai(content,content_img,date) VALUES (?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1,dongtai.getContent());
        pstmt.setString(2,dongtai.getContentImg());
        pstmt.setDate(3,new Date(dongtai.getDate().getTime()));
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deleteDongtaisById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "DELETE FROM t_dongtai WHERE id= " + id;
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }
}
