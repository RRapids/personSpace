package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Photos;

import java.sql.SQLException;
import java.util.List;

public interface PhotoDAO {
    int insertPhoto(Photos photos) throws SQLException;

    int deletePhotoById(int id) throws SQLException;

    List<Photos> getPhotoByUser(int id) throws SQLException;
}
