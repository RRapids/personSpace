package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.PhotoDAO;
import com.soft7.web.personSpace.entity.Logs;
import com.soft7.web.personSpace.entity.Photos;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhotoDAOImpl implements PhotoDAO {
    @Override
    public int insertPhoto(Photos photos) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_photos(photo_name,pho_details,create_date,user_id) VALUES (?,?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, photos.getPhotoname());
        pstmt.setString(2, photos.getPhotodetails());
        pstmt.setDate(3, new Date(photos.getCreatedate().getTime()));
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deletePhotoById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_photos WHERE id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public List<Photos> getPhotoByUser(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_photos WHERE user_id = ? ";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<Photos> photoList = new ArrayList<>();
        while (rs.next()) {
            Photos photos = new Photos();
            photos.setId(rs.getInt("id"));
            photos.setPhotoname(rs.getString("photo_name"));
            photos.setPhotodetails(rs.getString("pho_details"));
            photos.setCreatedate(rs.getDate("create_date"));
            photoList.add(photos);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return photoList;
    }


}