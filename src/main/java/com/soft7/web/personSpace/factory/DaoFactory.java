package com.soft7.web.personSpace.factory;


import com.soft7.web.personSpace.dao.LogDAO;
import com.soft7.web.personSpace.dao.MessageDAO;
import com.soft7.web.personSpace.dao.UserDAO;
import com.soft7.web.personSpace.daoImpl.LogDAOImpl;
import com.soft7.web.personSpace.daoImpl.MessageDAOImpl;
import com.soft7.web.personSpace.daoImpl.UserDaoImpl;

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
}
