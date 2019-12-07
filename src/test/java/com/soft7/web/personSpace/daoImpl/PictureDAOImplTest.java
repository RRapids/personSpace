package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.PictureDAO;
import com.soft7.web.personSpace.entity.Pictures;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname PictureDAOImplTest
 * @Description TODO
 * @Date 2019/12/7 16:39
 * @Created by tf_yuan
 */
public class PictureDAOImplTest {
    private PictureDAO pictureDAO = DaoFactory.getPictureDAOInstance();

    @Test
    public void insertPicture() {
    }

    @Test
    public void deletePictureById() {
    }

    @Test
    public void getPicturesByPhoto() {
        List<Pictures> picturesList = new ArrayList<>();
        try {
            picturesList = pictureDAO.getPicturesByPhoto(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        picturesList.forEach(pictures -> System.out.println(pictures));
    }
}