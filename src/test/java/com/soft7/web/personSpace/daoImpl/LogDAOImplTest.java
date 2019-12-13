package com.soft7.web.personSpace.daoImpl;

import com.soft7.web.personSpace.dao.LogDAO;
import com.soft7.web.personSpace.entity.Logs;
import com.soft7.web.personSpace.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname LogDAOImplTest
 * @Description TODO
 * @Date 2019/12/11 17:47
 * @Created by tf_yuan
 */
public class LogDAOImplTest {
        private LogDAO logDAO = DaoFactory.getLogDAOInstance();
    @Test
    public void selectAllLogs() {
        List<Logs> logsList = null;
        try {
            logsList = logDAO.selectAllLogs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logsList.forEach(logs -> System.out.println(logs));
    }

    @Test
    public void insertLogs() {
    }

    @Test
    public void deleteLogsById() {
    }

    @Test
    public void selectLogsLike() {
    }

    @Test
    public void readLogById() {
        try {
           Logs logs =  logDAO.readLogById(1);
            System.out.println(logs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}