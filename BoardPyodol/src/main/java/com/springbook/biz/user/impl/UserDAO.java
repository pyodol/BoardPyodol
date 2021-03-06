package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVo;
@Repository("userDAO")
public class UserDAO {
		private Connection conn= null;
		private PreparedStatement stmt = null;
		private ResultSet rs =null;
		
		private final String USER_GET = "select * from users where id=? and password=?";
		
		public UserVo getUser (UserVo vo) {
			UserVo user =null;
			try {
				System.out.println("=====> JDBC로 GetUser() 기능처리");
				conn=JDBCUtil.getConnection();
				stmt = conn.prepareStatement(USER_GET);
				stmt.setString(1 , vo.getId());
				stmt.setString(2,  vo.getPassword());
				rs= stmt.executeQuery();
				if(rs.next()) {
					user =new UserVo();
					user.setId(rs.getString("ID"));
					user.setName(rs.getString("PASSWORD"));
					user.setPassword(rs.getString("NAME"));
					user.setRole(rs.getString("ROLE"));
				}
				
			}catch (Exception e ) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs, stmt, conn);;
			}
			return user;
		}
		
		
		
		
}
