package top.inick.study.jdbc;

import java.sql.*;

public class Demo01 {
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//准备连接数据库的相关信息
		String USER = "root";
		String PASSWORD = "root";
		String DB_URL = "///test";  
		// /// 等同于 jdbc:mysql://hocalhost:3306/test
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//利用 DriverManager 获取 Connection 对象
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	}

}
