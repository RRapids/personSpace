package com.soft7.web.personSpace.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

	private String DBDRIVER	= "com.mysql.jdbc.Driver" ;
	private String DBURL = "jdbc:mysql://localhost:3306/db_personspace" ;
	private String DBUSER	= "root" ;
	private String DBPASSWORD = "root" ;
	private Connection conn	= null ;

	public DataBaseConnection()
	{
		try
		{
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
		}
		catch (Exception e)
		{
		}
	}

	public Connection getConnection()
	{
		return this.conn ;
	}
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
		}
	}

    public static void main(String[] args) {
        System.out.println("OK");
    }

};