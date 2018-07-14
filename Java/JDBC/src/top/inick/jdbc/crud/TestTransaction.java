package top.inick.jdbc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import top.inick.jdbc.util.DBUtils;

public class TestTransaction {
	@Test()
	public void test1() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		
		try {
			conn = DBUtils.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			//mysql默认级别 repeatable read
			conn.setAutoCommit(false); //相当于开启事务 begin | start transaction
			ps = conn.prepareStatement(" update account set money = money - 100 where id = 1");
			ps.executeUpdate();
			ps = conn.prepareStatement(" update account set money = money + 100 where id = 2");
			ps.executeUpdate();
			conn.commit();		//commit
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
