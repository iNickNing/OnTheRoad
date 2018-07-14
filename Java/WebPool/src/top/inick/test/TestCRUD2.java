package top.inick.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import top.inick.util.C3P0Utils;

public class TestCRUD2 {
	
	@Test
	public void test1() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = C3P0Utils.getConnection();
			ps = conn.prepareStatement("insert into account(name, money) values('ssss', 5000)");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(null, ps, conn);
		}
	}
}
