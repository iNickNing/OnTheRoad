package top.inick.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import junit.framework.Assert;

public class TestCRUD {

	@Test
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
	
	@Test
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
