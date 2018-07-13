package top.inick.service.impl;

import top.inick.dao.UserDao;
import top.inick.dao.impl.UserDaoImpl;
import top.inick.domain.User;
import top.inick.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	

	public void register(User user) throws Exception {
		
	}

}
