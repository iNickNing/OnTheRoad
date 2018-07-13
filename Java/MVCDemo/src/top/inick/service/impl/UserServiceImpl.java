package top.inick.service.impl;

import top.inick.dao.UserDao;
import top.inick.dao.impl.UserDaoImpl;
import top.inick.domain.User;
import top.inick.exception.UsersException;
import top.inick.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	

	public void register(User user) throws Exception {
		userDao.addUser(user);
	}


	@Override
	public User login(User user) throws UsersException{
		User u = null;
		try {
			u = userDao.findUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(u == null) {
			throw new UsersException("用户或密码不正确");
		}
		return u;
	}

}
