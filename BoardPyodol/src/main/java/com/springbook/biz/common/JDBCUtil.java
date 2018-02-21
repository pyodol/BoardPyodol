package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUtil {

	 public static Connection getConnection() {
		try {
			 Class.forName("oracle.jdbc.OracleDrvier");
			 return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","96089608");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	 }
	 
	 public static  void close (PreparedStatement stmt, Connection conn) {
		 	if(stmt != null) {
		 		try {
		 			 if(!stmt.isClosed()) stmt.close() ; 
		 			
		 		}catch (Exception e) {
		 			e.printStackTrace();
		 		}finally {
		 			stmt =null;
		 		}
		 	}
		 	
		 	if(conn !=null) {
		 		try {
		 			if(!conn.isClosed()) conn.close();
		 		}catch (Exception e) {
		 			e.printStackTrace();
		 		}finally {
		 			conn=null;
		 		}
		 	}
	 }
}
