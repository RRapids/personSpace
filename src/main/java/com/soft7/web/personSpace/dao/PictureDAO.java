package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Pictures;

import java.sql.SQLException;
import java.util.List;

public interface PictureDAO {
    int insertPicture(Pictures pictures) throws SQLException;

    int deletePictureById(int id) throws SQLException;

    List<Pictures> getPicturesByPhoto(int id) throws SQLException;
}
