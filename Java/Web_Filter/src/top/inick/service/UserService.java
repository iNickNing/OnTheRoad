package top.inick.service;

import java.sql.SQLException;

import top.inick.dao.UserDao;
import top.inick.domain.User;

public class UserService {
	UserDao ud = new UserDao();

	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			return ud.findUser(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
