package top.inick.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import top.inick.entity.User;

public class TestCRUD {
	
	@Test
	public void testSelect3() {
		//准备连接数据库的相关信息
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// 默认本机 
		
		//利用 DriverManager 获取 Connection 对象
		Connection conn = null;
		//得到执行sql语句的对象Statement
		Statement stmt = null;
		//执行sql语句,并返回结果
		ResultSet rs = null;
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from users");
			
			List<User> list = new ArrayList<>();
			
			//处理结果
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭资源
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
			
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	
	
	@Test
	public void testSelect() throws ClassNotFoundException, SQLException {
		//准备连接数据库的相关信息
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// 默认本机 
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//利用 DriverManager 获取 Connection 对象
		Connection conn = DriverManager.getConnection(URL);
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		//执行sql语句,并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		List<User> list = new ArrayList<>();
		
		//处理结果
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
		
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}
	
	@Test
	public void testSelect2() throws ClassNotFoundException, SQLException {
		//准备连接数据库的相关信息
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// 默认本机 
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//利用 DriverManager 获取 Connection 对象
		Connection conn = DriverManager.getConnection(URL);
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		//执行sql语句,并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		List<User> list = new ArrayList<>();
		
		rs.afterLast();
		rs.previous();
		//处理结果
		//while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			System.out.println(user);
			list.add(user);
		//}
		
		//System.out.println(list);
		
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

	//@Test
	public void test1() throws ClassNotFoundException, SQLException {
		//准备连接数据库的相关信息
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// 默认本机 
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//利用 DriverManager 获取 Connection 对象
		Connection conn = DriverManager.getConnection(URL);
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		//执行sql语句,并返回结果
		int i = stmt.executeUpdate("INSERT INTO users VALUES(4, 'tom', '123', 'tom@163.com', '2015-09-05')");
		System.out.println(i);
		
		//关闭资源
		stmt.close();
		conn.close();
		
	}
	
	//@Test
	public void test2() throws ClassNotFoundException, SQLException {
		//准备连接数据库的相关信息
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// 默认本机 
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//利用 DriverManager 获取 Connection 对象
		Connection conn = DriverManager.getConnection(URL);
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		//执行sql语句,并返回结果
		int i = stmt.executeUpdate("UPDATE users SET `name` = 'jerry', `password` = '333', `email` = 'jerry@163' WHERE id = 4");
		System.out.println(i);
		
		//关闭资源
		stmt.close();
		conn.close();
		
	}

}
