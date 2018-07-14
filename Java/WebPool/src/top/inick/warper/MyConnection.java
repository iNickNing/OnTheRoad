package top.inick.warper;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

//1、编写一个类，实现与被包装类相同的接口。（具备相同的行为）
//2、定义一个被包装类类型的变量。
//3、定义构造方法，把被包装类的对象注入，给被包装类变量赋值。
//4、对于不需要改写的方法，调用原有的方法。
//5、对于需要改写的方法，写自己的代码 

public class MyConnection extends MyConnectionWarper{

	private Connection oldConnection; // com.mysql.jdbc.Connection\
	private LinkedList<Connection> pool;
	public MyConnection(Connection oldConnection, LinkedList<Connection> pool) {
		this.oldConnection = oldConnection;	//得到com.mysql.jdbc.Connection
		this.pool = pool;
	}
	
	@Override
	public void close() throws SQLException {
		pool.addLast(oldConnection);
		
	}

}
