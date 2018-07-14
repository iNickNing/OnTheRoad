package top.inick.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import top.inick.entity.User;
import top.inick.util.C3P0Utils;

public class TestSelect {
	
	@Test
	public void testSelect1() throws SQLException {
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		List<User> list = qr.query("select * from users", new ResultSetHandler<List<User>>() {

			@Override
			public List<User> handle(ResultSet rs) throws SQLException {
					
				List<User> list = new ArrayList<>();
				while(rs.next()) {
					User u = new User();
					u.setId(rs.getInt("id"));
					u.setUsername(rs.getString("username"));
					u.setPassword(rs.getString("password"));
					u.setEmail(rs.getString("email"));
					u.setBirthday(rs.getDate("birthday"));
					list.add(u);
				}
				
				return list;
			}
			
		});
		
		for (User user : list) {
			System.out.println("1:" + user);
		}
	}
	
	@Test
	public void testSelect2() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		List<User> list = qr.query("select * from users where id = ?", new BeanListHandler<User>(User.class), 2);
		for (User user : list) {
			System.out.println("2:" + user);
		}
	}
}
