package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Photos;

import java.sql.SQLException;

public interface PhotoDAO {
    Long insertPhoto(Photos photos) throws SQLException;

    int deletePhotoById(long id) throws SQLException;

    Photos getPhotoById(long id) throws SQLException;
}
