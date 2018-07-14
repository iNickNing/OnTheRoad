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
	 * 根据用户名和密码查找用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
	
	/**
	 * 根据用户名查找用户是否存在
	 * @param username
	 * @return
	 */
	public boolean findUserByName(String username);
}
