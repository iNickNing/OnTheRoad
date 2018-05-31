package top.inick.study.jdbc;

import java.sql.*;

public class Demo02 {
	
	//�ǵ����jar��path

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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

}
