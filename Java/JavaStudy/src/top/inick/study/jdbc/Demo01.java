package top.inick.study.jdbc;

import java.sql.*;
import java.util.Properties;

import org.junit.Test;

public class Demo01 {
	
	//记得添加jar到path
	@Test
	public void test1() throws ClassNotFoundException, SQLException {
		//准备连接数据库的相关信息
		String USER = "root";
		String PASSWORD = "root";
		String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";  
		// /// 默认本机
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//利用 DriverManager 获取 Connection 对象
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		//执行sql语句,并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		//处理结果
		while(rs.next()) {
			System.out.println(rs.getObject(1));	//数据库从1开始
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("--------------");
		}
		
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
		
	}
	
	@Test
	public void test2() throws ClassNotFoundException, SQLException {
		//准备连接数据库的相关信息
		String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";  
		// /// 默认本机
		
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//利用 DriverManager 获取 Connection 对象
		Connection conn = DriverManager.getConnection(DB_URL, info);
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		//执行sql语句,并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		//处理结果
		while(rs.next()) {
			System.out.println(rs.getObject(1));	//数据库从1开始
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("--------------");
		}
		
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
