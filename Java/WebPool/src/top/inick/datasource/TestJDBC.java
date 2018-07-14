package top.inick.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;


public class TestJDBC {

	@Test
	public void test1() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		DataSource ds = new MyDataSource();
		try {
			conn = ds.getConnection();  //从池中取出一个连接
			ps = conn.prepareStatement("select * from account");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	
}
