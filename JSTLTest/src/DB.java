package com.cdac.met;

import com.mysql.cj.jdbc.*;
import java.sql.*;

class DB{
 	private static MysqlConnectionPoolDataSource pool;

	public static Connection getConnection() throws SQLException{
		if(pool == null){
			 pool = new MysqlConnectionPoolDataSource();
			pool.setURL("jdbc:mysql://localhost/payroll?useSSL=false");
			pool.setUser("root");
			pool.setPassword("root");
		}
		
		return pool.getConnection();
	}
}
