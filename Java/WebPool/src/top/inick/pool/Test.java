package top.inick.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Test {
	
	public static void main(String[] args) {
		
		DataSource ds = new MyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ds.getConnection();		//com.mysql.jdbc.Connection
			ps = conn.prepareStatement("select * from account");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
}
