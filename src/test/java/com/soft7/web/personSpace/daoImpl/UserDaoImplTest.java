package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.UserDAO;
import com.soft7.web.personSpace.entity.User;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname UserDaoImplTest
 * @Description TODO
 * @Date 2019/12/5 8:19
 * @Created by tf_yuan
 */
public class UserDaoImplTest {
    private UserDAO userDao = DaoFactory.getUserDAOInstance();


    @Test
    public void login() {
    }

    @Test
    public void getUserByAccount() {
        try {
            User user = userDao.getUserByAccount("111");
            if (user != null) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAllUsers() {
        List<User> userList = null;
        try {
            userList = userDao.selectAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void insertUser() {
        User user = new User();
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void updateUser() {
    }
}