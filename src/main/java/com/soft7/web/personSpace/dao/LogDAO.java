package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Logs;
import com.soft7.web.personSpace.entity.Message;
import com.soft7.web.personSpace.util.SplitPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname LogDAO
 * @Description TODO
 * @Date 2019/12/4 9:09
 * @Created by tf_yuan
 * 增删改
 */

public interface LogDAO {
    //获取所有日志
    List<Logs> selectAllLogs() throws SQLException;
    //新增日志
    int insertLogs(Logs logs) throws SQLException;
    //根据id查看日志
    public Logs readLogById(int id) throws SQLException;
    //根据id删除日志
    int deleteLogsById(int id) throws SQLException;
    //根据关键字模糊查询
    List<Logs> selectLogsLike(String keywords) throws SQLException;
}
