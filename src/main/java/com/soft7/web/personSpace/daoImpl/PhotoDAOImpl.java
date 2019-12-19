package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.PhotoDAO;
import com.soft7.web.personSpace.entity.Photos;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhotoDAOImpl implements PhotoDAO {
    @Override
    public int insertPhoto(Photos photos) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_photos(photo_name,pho_details,create_date,user_id,photo_cover) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, photos.getPhotoname());
        pstmt.setString(2, photos.getPhotodetails());
        pstmt.setDate(3, new Date(photos.getCreatedate().getTime()));
        pstmt.setInt(4,photos.getUserid());
        pstmt.setString(5,photos.getPhotoCover());
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deletePhotoById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "DELETE FROM t_photos WHERE id= " + id;
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
            photos.setPhotoCover(rs.getString("photo_cover"));
            photos.setUserid(id);
            photoList.add(photos);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return photoList;
    }

    @Override
    public List<Photos> selectAllPhotos() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_photos";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Photos> photosList = new ArrayList<>();
        while (rs.next()){
            Photos photos = new Photos();
            photos.setId(rs.getInt("id"));
            photos.setPhotoname(rs.getString("photo_name"));
            photos.setPhotodetails(rs.getString("pho_details"));
            photos.setCreatedate(rs.getDate("create_date"));
            photos.setUserid(rs.getInt("user_id"));
            photos.setPhotoCover(rs.getString("photo_cover"));
            photosList.add(photos);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return photosList;
    }
}
