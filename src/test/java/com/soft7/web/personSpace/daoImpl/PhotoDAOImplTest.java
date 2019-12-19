package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.PhotoDAO;
import com.soft7.web.personSpace.entity.Photos;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PhotoDAOImplTest {
private PhotoDAO photoDAO = DaoFactory.getPhotoDAOInstance();
    @Test
    public void getPhotoByUser() {
        try {
            List<Photos> photosList = photoDAO.getPhotoByUser(1);
            System.out.println(photosList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void selectAllPhotos() {
        try {
            List photosList = photoDAO.selectAllPhotos();
            System.out.println(photosList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertPhoto() {
        Photos photos = new Photos();
        photos.setPhotoname("photoName");
        photos.setPhotodetails("details");
        photos.setPhotoCover("photoCover");
        photos.setUserid(1);
        photos.setCreatedate(new Date());
        try {
           int n = photoDAO.insertPhoto(photos);
            System.out.println(n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
