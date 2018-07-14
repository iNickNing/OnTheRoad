package top.inick.warper;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import top.inick.datasource.MyConnection;
import top.inick.util.DBUtils;

public class MyDataSource implements DataSource  {
	
	//创建一个存放连接的池子
	/*private static LinkedList<Connection> pool = 
			(LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>()); //报错*/
	
	private static LinkedList<Connection> pool = new LinkedList<Connection>();	//不报错,但是还是线程安全的吗
	 
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
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if(pool.size() > 0) {
			conn = pool.removeFirst();	//从数据库中拿第一个
			Connection myConn = new MyConnection(conn, pool);
			return myConn;
		} else {
			//等待
			//创建新连接

			throw new RuntimeException("服务器忙");
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
