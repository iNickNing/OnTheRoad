package top.inick.test;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import top.inick.util.C3P0Utils;

public class TestCRUD {
	
	//@Test
	public void testInsert() throws SQLException {
		//创建一个QueryRunner 对象
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		qr.update("insert into users(username, password, email, birthday) values(?, ?, ?, ?)", "张三", "12333", "2288@qq.com","2299-8-9");
	}
	
	//@Test
	public void testUpdate() throws SQLException {
		//创建一个QueryRunner 对象
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		qr.update("update users set username = ?,password = ? where id = ?", "李四", "12333", 5);
	}
	
	//@Test
	public void testDelete() throws SQLException {
		//创建一个QueryRunner 对象
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		qr.update("delete from users where id = ?", 5);
	}
	
	@Test
	public void testBatchs() throws SQLException {
		//创建一个QueryRunner 对象
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		Object[][] params = new Object[10][];
		for(int i = 0; i < params.length; i++) {
			params[i] = new Object[]{"菜10"+1, "123", "c11@qq.com", new Date()};//给每次执行的sql语句的?赋值
		}
		qr.batch("insert into users(username, password, email, birthday) values(?, ?, ?, ?)", params);
	}
}
