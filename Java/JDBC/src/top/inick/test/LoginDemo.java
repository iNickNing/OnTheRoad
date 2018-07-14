package top.inick.test;

import java.sql.*;
import java.util.Scanner;


import top.inick.entity.User;
import top.inick.jdbc.util.DBUtils;

public class LoginDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = input.nextLine(); 
		System.out.println("请输入密码：");
		String password = input.nextLine();
		User u = findUser(name, password);
		if(u != null) {
			System.out.println("欢迎您"+u.getName()+"登录成功");
		} else {
			System.out.println("登录失败");
		}
	}
	
	public static User findUser(String name, String password) {
		
		String sql = "select * from users where name = ? and password = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password")); 
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getDate("birthday"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
		
		return u;
	}

}
