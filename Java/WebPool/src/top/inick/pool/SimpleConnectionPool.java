package top.inick.pool;
//模拟数据库连接池,但不具备实际开发意义

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;

import top.inick.util.DBUtils;

public class SimpleConnectionPool { 
	
	//创建一个存放连接的池子
	private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
	
	static {	//初始化池子
		for(int i = 0; i < 10; i++) {
			try {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionInInitializerError("初始化数据库连接失败,请检查配置");
			}
		}
	}
	
	public Connection getConnectionForPool() {
		Connection conn = null;
		if(pool.size() > 0) {
			conn = pool.removeFirst();	//从数据库中拿第一个
		} else {
			//等待
			//创建新连接
			
			
			throw new RuntimeException("服务器忙");
		}
		return conn;
	}
	
	public void release(Connection conn) {	//释放链接
		pool.addLast(conn);	//将链接放回池子
	}
}
