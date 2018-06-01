package top.inick.jdbc.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import top.inick.entity.User;
import top.inick.jdbc.util.DBUtils;

public class TestCRUD {
	
	@Test
	public void testSelect() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");
			List<User> list = new ArrayList<>();
			//������
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				System.out.println(user);
				list.add(user);
			}
			System.out.println(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
	}
	
	@Test
	public void testInsert() {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?)");
			stmt.setInt(1, 5);
			stmt.setString(2, "tom");
			stmt.setString(3, "3333");
			stmt.setString(4, "tom@163.com");
			stmt.setDate(5, new Date(System.currentTimeMillis()));
			
			
			int i = stmt.executeUpdate();
			if(i > 0) {
				System.out.println("success");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, stmt, conn);
		}
		
	}
	
	@Test
	public void testUpdate() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate("update users set name = 'jerry' where id = 4");
			if(i > 0) {
				System.out.println("success");
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, stmt, conn);
		}
		
	}
	
	@Test
	public void testDelete() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate("delete from users where id = 4");
			if(i > 0) {
				System.out.println("success");
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, stmt, conn);
		}
		
	}
}
