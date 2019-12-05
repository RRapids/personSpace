package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Classname UserDAO
 * @Description TODO
 * @Date 2019/12/3 18:34
 * @Created by tf_yuan
 */
public interface UserDAO {
    //登录验证
    public boolean login(User user) throws Exception;
    //根据账号查询
    User getUserByAccount(String accountNumber) throws SQLException;
    //查所有
    List<User> selectAllUsers() throws SQLException;
    //新增用户
    int insertUser(User user) throws SQLException;
    //删除
    int deleteUserById(int id) throws SQLException;
    //修改
    int updateUser(User user) throws SQLException;
    //检查注册用户是否存在
    public boolean checkUser(User user) throws Exception ;
    //查询用户id
    public int QueryId(User user) throws Exception ;
}
