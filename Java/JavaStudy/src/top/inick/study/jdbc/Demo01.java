package top.inick.study.jdbc;

import java.sql.*;

public class Demo01 {
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//׼���������ݿ�������Ϣ
		String USER = "root";
		String PASSWORD = "root";
		String DB_URL = "///test";  
		// /// ��ͬ�� jdbc:mysql://hocalhost:3306/test
		
		//������������
		Class.forName("com.mysql.jdbc.Driver");
		//���� DriverManager ��ȡ Connection ����
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	}

}
