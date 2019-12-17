package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.UserDAO;
import com.soft7.web.personSpace.entity.User;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

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
        User user=new User();
        user.setAccountNumber("111");
        user.setPassword("123456");
        user.setFlag("1");
        try {
            System.out.println(userDao.login(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Test
    public void updateInfo() {
        User user = new User();
        user.setUsername("111");
        user.setPassword("222");
        user.setPhoneNumber(333);
        user.setEmail("444");
        user.setGender("555");
        user.setAge(20);
        user.setId(3);
        try {
            userDao.updateInfo(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}