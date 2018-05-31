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
		//׼���������ݿ�������Ϣ
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// Ĭ�ϱ��� 
		
		//������������
		Class.forName("com.mysql.jdbc.Driver");
		
		//���� DriverManager ��ȡ Connection ����
		Connection conn = DriverManager.getConnection(URL);
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		//ִ��sql���,�����ؽ��
		int i = stmt.executeUpdate("INSERT INTO users VALUES(4, 'tom', '123', 'tom@163.com', '2015-09-05')");
		System.out.println(i);
		
		//�ر���Դ
		stmt.close();
		conn.close();
		
	}
	
	@Test
	public void test2() throws ClassNotFoundException, SQLException {
		//׼���������ݿ�������Ϣ
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// Ĭ�ϱ��� 
		
		//������������
		Class.forName("com.mysql.jdbc.Driver");
		
		//���� DriverManager ��ȡ Connection ����
		Connection conn = DriverManager.getConnection(URL);
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		//ִ��sql���,�����ؽ��
		int i = stmt.executeUpdate("UPDATE users SET `name` = 'jerry', `password` = '333', `email` = 'jerry@163' WHERE id = 4");
		System.out.println(i);
		
		//�ر���Դ
		stmt.close();
		conn.close();
		
	}

}
