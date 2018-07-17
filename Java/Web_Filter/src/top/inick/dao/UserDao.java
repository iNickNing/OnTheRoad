package top.inick.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import top.inick.domain.User;
import top.inick.util.C3P0Utils;

public class UserDao {
	
	
	public User findUser(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		return qr.query("select * from users where username=? and password=?", 
				new BeanHandler<User>(User.class), username, password);
	}
	
}
