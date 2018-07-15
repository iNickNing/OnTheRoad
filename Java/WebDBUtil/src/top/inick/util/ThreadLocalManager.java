package top.inick.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ThreadLocalManager {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//得到一个连接
	public static Connection getConnection() {
		Connection conn = tl.get();	//从当前线程中取一个线程
		if(conn == null) {
			conn = C3P0Utils.getConnection();	//没有则从池子里面拿一个
			tl.set(conn);	//放到当前线程中
		}
		return conn;
	}
	
	//开启事务
	public static void starTransaction() {
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//提交事务
	public static void commit() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//回滚事务
	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			getConnection().close();	//释放连接,放回池中
			tl.remove();	//移除当前线程对象中的conn
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
