package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.UserDAO;
import com.soft7.web.personSpace.entity.User;
import com.soft7.web.personSpace.util.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 2019/11/28 16:43
 * @Created by tf_yuan
 */
public class UserDaoImpl implements UserDAO {

    @Override
    public boolean login(User user) throws Exception {
        Boolean flag = false;
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select active,avatar,id from t_user where account_number=? and password=? and flag=?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getAccountNumber());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getFlag());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            flag = true;
            user.setActive(rs.getString(1));
            user.setAvatar(rs.getString(2));
            user.setId(rs.getInt(3));
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return flag;
    }

    @Override
    public User getUserByAccount(String accountNumber) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_user where account_number = ?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, accountNumber);
        ResultSet rs = pstmt.executeQuery();
        User user = new User();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String userName = rs.getString("user_name");
            String account_number = rs.getString("account_number");
            String password = rs.getString("password");
            String avatar = rs.getString("avatar");
            Integer phone = rs.getInt("phone_number");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            Integer age = rs.getInt("age");
            String active = rs.getString("active");
            String flag = rs.getString("flag");
            user.setId(id);
            user.setUsername(userName);
            user.setAccountNumber(account_number);
            user.setPassword(password);
            user.setAvatar(avatar);
            user.setPhoneNumber(phone);
            user.setEmail(email);
            user.setGender(gender);
            user.setAge(age);
            user.setActive(active);
            user.setFlag(flag);
        }
        rs.close();
        pstmt.close();
        dbc.close();
        return user;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM t_user";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<User> usersList = convert(rs);
        rs.close();
        pstmt.close();
        dbc.close();
        return usersList;
    }

    @Override
    public int insertUser(User user) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "INSERT INTO t_user(account_number,user_name,email,password,active,flag) VALUES(?,?,?,?,?,?)";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getAccountNumber());
        pstmt.setString(2, user.getUsername());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getPassword());
        pstmt.setString(5, user.getActive());
        pstmt.setString(6, user.getFlag());
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int deleteUserById(int id) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "DELETE FROM t_user WHERE id= " + id;
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int updateUser(User user) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "UPDATE t_user SET avatar=? WHERE id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getAvatar());
        pstmt.setInt(2, user.getId());
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public int updateInfo(User user) throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "UPDATE t_user SET user_name=?,password=?,phone_number=?,email=?,gender=?,age=? WHERE id =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setInt(3, user.getPhoneNumber());
        pstmt.setString(4, user.getEmail());
        pstmt.setString(5, user.getGender());
        pstmt.setInt(6, user.getAge());
        pstmt.setInt(7, user.getId());
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;
    }

    @Override
    public boolean checkUser(User user) throws Exception {
        Boolean flag = false;
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select * from t_user where user_name=?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            flag = true;
        }
        dbc.close();
        pstmt.close();
        return flag;
    }

    @Override
    public int QueryId(User user) throws Exception {
        int b = 0;
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "select id from t_user where user_name =?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        //查询的结果保存在结果集
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            //取id
            b = rs.getInt(1);
        }
        rs.close();
        pstmt.close();
        return b;
    }

    private List<User> convert(ResultSet rs) throws SQLException {
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("user_name"));
            user.setAccountNumber(rs.getString("account_number"));
            user.setPassword(rs.getString("password"));
            user.setAvatar(rs.getString("avatar"));
            user.setPhoneNumber(rs.getInt("phone_number"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setAge(rs.getInt("age"));
            user.setActive(rs.getString("active"));
            user.setFlag(rs.getString("flag"));
            userList.add(user);
        }
        return userList;
    }
}
