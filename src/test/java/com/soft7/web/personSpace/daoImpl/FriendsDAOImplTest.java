package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.FriendsDAO;
import com.soft7.web.personSpace.entity.Friends;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname FriendsDAOImplTest
 * @Description TODO
 * @Date 2019/12/6 10:46
 * @Created by tf_yuan
 */
public class FriendsDAOImplTest {
    private FriendsDAO friendsDAO = DaoFactory.getFriendsDAOInstance();
    @Test
    public void insertFriend() {

    }

    @Test
    public void deleteFriendById() {
    }

    @Test
    public void getFriendById() {


        try {
           friendsDAO.getFriendById(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

    @Test
    public void getAllFriends() {
        List<Friends> friendsList = new ArrayList<>();
        try {
            friendsList = friendsDAO.getAllFriends();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        friendsList.forEach(friends -> System.out.println(friends));
    }
}