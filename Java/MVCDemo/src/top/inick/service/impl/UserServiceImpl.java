package top.inick.service.impl;

import top.inick.dao.UserDao;
import top.inick.dao.impl.UserDaoImpl;
import top.inick.domain.User;
import top.inick.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	

	public void register(User user) throws Exception {
		userDao.addUser(user);
	}


	@Override
	public User login(User user) {
		User u = null;
		try {
			u = userDao.findUser(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

}
