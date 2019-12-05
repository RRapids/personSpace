package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Friends;

import java.sql.SQLException;
import java.util.List;

public interface FrendsDAO {
    Long insertFriend(Friends friends) throws SQLException;

    int deleteFriendById(long id) throws SQLException;

    Friends getFriendById(long id) throws SQLException;

    List<Friends> getAllFriends() throws SQLException;
}
