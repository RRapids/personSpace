package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.DongtaiDAO;
import com.soft7.web.personSpace.entity.Dongtai;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname DongtaiDAOImplTest
 * @Description TODO
 * @Date 2019/12/13 9:57
 * @Created by tf_yuan
 */
public class DongtaiDAOImplTest {
    private DongtaiDAO dongtaiDAO = DaoFactory.getDongtaiDAOInstance();

    @Test
    public void selectAllDongtai() {
        List<Dongtai> list = new ArrayList();
        try {
            list = dongtaiDAO.selectAllDongtai();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.forEach(dongtai -> System.out.println(dongtai));
    }

    @Test
    public void insertDontai() {
        Dongtai dongtai = new Dongtai();
        dongtai.setContent("11");
        dongtai.setContentImg("dfs");
        dongtai.setDate(new Date());
        try {
            dongtaiDAO.insertDontai(dongtai);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}