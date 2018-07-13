package top.inick.dao;

import top.inick.domain.User;

public interface UserDao {

	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean addUser(User user) throws Exception;
	
	/**
	 * 根据要求查找用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
	
}
