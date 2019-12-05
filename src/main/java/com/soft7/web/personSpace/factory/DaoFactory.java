package com.soft7.web.personSpace.factory;


import com.soft7.web.personSpace.dao.*;
import com.soft7.web.personSpace.daoImpl.*;

/**
 * @Classname DaoFactory
 * @Description TODO
 * @Date 2019/11/28 16:44
 * @Created by tf_yuan
 */
public class DaoFactory {
    public static UserDAO getUserDAOInstance() {
        return new UserDaoImpl();
    }

    public static MessageDAO getMessageDAOInstance() {
        return new MessageDAOImpl();
    }

    public static LogDAO getLogDAOInstance() {
        return new LogDAOImpl();
    }
//    public static FrendsDAO getFriendsDAOInstance(){
//
//    }
    public static PhotoDAO getPhotoDAOInstance(){
        return new PhotoDAOImpl();
    }
    public static PictureDAO getPictureDAOInstance(){
        return new PictureDAOImpl();
    }
}
