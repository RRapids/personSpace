package com.soft7.web.personSpace.dao;

import com.soft7.web.personSpace.entity.Dongtai;
import com.soft7.web.personSpace.entity.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * @Classname DongtaiDAO
 * @Description TODO
 * @Date 2019/12/13 9:53
 * @Created by tf_yuan
 */
public interface DongtaiDAO {
    //获取全部
    List<Dongtai> selectAllDongtai() throws SQLException;
    //增加
    int insertDontai(Dongtai dongtai) throws SQLException;
    //删除
    int deleteDongtaisById(int id) throws SQLException;


}
