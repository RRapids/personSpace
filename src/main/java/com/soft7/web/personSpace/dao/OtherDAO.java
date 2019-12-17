package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Other;

import java.sql.SQLException;
import java.util.List;

/**
 * @Classname OtherDAO
 * @Description TODO
 * @Date 2019/12/15 15:29
 * @Created by tf_yuan
 */
public interface OtherDAO {
    Other getOtherById(int id) throws SQLException;

    List<Other> getAllOther() throws SQLException;
    Other getOtherByAccount(String account) throws SQLException;
}
