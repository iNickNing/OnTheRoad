package top.inick.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import top.inick.util.DBCPUtils;

public class TestDBCP {
	@Test
	public void test01() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBCPUtils.getConnection();
			ps = conn.prepareStatement("..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCPUtils.release(null, ps, conn);
		}
	}
	
	
}
