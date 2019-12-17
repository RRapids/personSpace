package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.PictureDAO;
import com.soft7.web.personSpace.entity.Photos;
import com.soft7.web.personSpace.entity.Pictures;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PictureDAOImpl implements PictureDAO {
    @Override
    public int insertPicture(Pictures pictures) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_pictures(picture_name,picture,photo_id,pic_details,update,user_id) VALUES (?,?,?,?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, pictures.getPicturename());
        pstmt.setString(2, pictures.getPicture());
        pstmt.setInt(3,pictures.getPhotoid());
        pstmt.setString(4,pictures.getPicturesdetails());
        pstmt.setDate(5, new Date(pictures.getUpdate().getTime()));
        pstmt.setInt(6,pictures.getUserid());
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deletePictureById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "DELETE FROM t_pictures WHERE id= " + id;
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public List<Pictures> getPicturesByPhoto(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_pictures WHERE photo_id = ? ";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<Pictures> picturesList = new ArrayList<>();
        while (rs.next()) {
            Pictures pictures = new Pictures();
            pictures.setId(rs.getInt("id"));
            pictures.setPicturename(rs.getString("picture_name"));
            pictures.setPicture(rs.getString("picture"));
            pictures.setPhotoid(rs.getInt("photo_id"));
            pictures.setPicturesdetails(rs.getString("pic_details"));
            pictures.setUpdate(rs.getDate("update"));
            pictures.setUserid(rs.getInt("user_id"));
            picturesList.add(pictures);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return picturesList;
    }
}
