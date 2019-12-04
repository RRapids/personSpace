package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Pictures;

import java.sql.SQLException;
import java.util.List;

public interface PictureDAO {
    Long insertPicture(Pictures pictures) throws SQLException;

    int deletePictureById(long id) throws SQLException;

    Pictures getPictureById(long id) throws SQLException;

    List<Pictures> getPicturesByPhoto(long id) throws SQLException;
}
