package top.inick.jdbc.demo;

import java.sql.*;
import java.util.Properties;

import org.junit.Test;

public class Demo01 {
	
	//�ǵ����jar��path
	@Test
	public void test1() throws ClassNotFoundException, SQLException {
		//׼���������ݿ�������Ϣ
		String USER = "root";
		String PASSWORD = "root";
		String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";  
		// /// Ĭ�ϱ��� 
		
		//������������
		Class.forName("com.mysql.jdbc.Driver");
		
		//���� DriverManager ��ȡ Connection ����
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		//ִ��sql���,�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		
		//������
		while(rs.next()) {
			System.out.println(rs.getObject(1));	//���ݿ��1��ʼ
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("--------------");
		}
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
	}
	
	@Test
	public void test2() throws ClassNotFoundException, SQLException {
		//׼���������ݿ�������Ϣ
		String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";  
		// /// Ĭ�ϱ���
		
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		
		//������������
		Class.forName("com.mysql.jdbc.Driver");
		
		//���� DriverManager ��ȡ Connection ����
		Connection conn = DriverManager.getConnection(DB_URL, info);
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		//ִ��sql���,�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		
		//������
		while(rs.next()) {
			System.out.println(rs.getObject(1));	//���ݿ��1��ʼ
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("--------------");
		}
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
	}
	
	@Test
	public void test3() throws ClassNotFoundException, SQLException {
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
		ResultSet rs = stmt.executeQuery("select * from users");
		
		//������
		while(rs.next()) {
			System.out.println(rs.getObject("id"));	//���ݿ��1��ʼ
			System.out.println(rs.getObject("name"));
			System.out.println(rs.getObject("birthday"));
			System.out.println(rs.getObject("email"));
			System.out.println(rs.getObject("password"));
			System.out.println("--------------");
		}
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
