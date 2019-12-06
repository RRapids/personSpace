package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.FriendsDAO;
import com.soft7.web.personSpace.entity.Friends;
import com.soft7.web.personSpace.entity.User;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FriendsDAOImpl
 * @Description TODO
 * @Date 2019/12/6 10:40
 * @Created by tf_yuan
 */
public class FriendsDAOImpl implements FriendsDAO {
    @Override
    public int insertFriend(Friends friends) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_friends(account,name,avatar) VALUES(?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, friends.getAccount());
        pstmt.setString(2, friends.getName());
        pstmt.setString(3,friends.getAvatar());
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deleteFriendById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_friends where id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public Friends getFriendById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_friends where id = ?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Friends friends = new Friends();
        while (rs.next()){
            Integer friendsId = rs.getInt("id");
            String name = rs.getString("name");
            String account = rs.getString("account");
            String avatar = rs.getString("avatar");
            friends.setId(friendsId);
            friends.setName(name);
            friends.setAccount(account);
            friends.setAvatar(avatar);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return friends;
    }

    @Override
    public List<Friends> getAllFriends() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_friends";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Friends> friendsList = new ArrayList<>();
        while (rs.next()){
            Friends friends = new Friends();
            friends.setId(rs.getInt("id"));
            friends.setAccount(rs.getString("account"));
            friends.setName(rs.getString("name"));
            friends.setAvatar(rs.getString("avatar"));
            friendsList.add(friends);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return friendsList;
    }
}
