package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Friends;

import java.sql.SQLException;
import java.util.List;

public interface FriendsDAO {
    int insertFriend(Friends friends) throws SQLException;

    int deleteFriendById(int id) throws SQLException;

    Friends getFriendById(int id) throws SQLException;

    List<Friends> getAllFriends() throws SQLException;
    //查询重复记录

}
