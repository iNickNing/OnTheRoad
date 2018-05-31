package top.inick.study.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import top.inick.study.entity.User;

public class TestCRUD {
	
	@Test
	public void testSelect3() {
		//׼���������ݿ�������Ϣ
		String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&user=root&password=root";  
		// /// Ĭ�ϱ��� 
		
		//���� DriverManager ��ȡ Connection ����
		Connection conn = null;
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = null;
		//ִ��sql���,�����ؽ��
		ResultSet rs = null;
		try {
			//������������
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL);
			
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//�ر���Դ
			
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
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	
	@Test
	public void testSelect2() throws ClassNotFoundException, SQLException {
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
		
		List<User> list = new ArrayList<>();
		
		rs.afterLast();
		rs.previous();
		//������
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
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

	//@Test
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
	
	//@Test
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
