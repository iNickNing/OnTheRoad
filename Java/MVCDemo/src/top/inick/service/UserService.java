package top.inick.service;

import top.inick.domain.User;
import top.inick.exception.UserExistException;
import top.inick.exception.UsersException;

public interface UserService {
	/**
	 * 添加(注册)用户信息
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	public User login(User user) throws UsersException;
	
	/**
	 * 根据用户名查找用户是否存在
	 * @param username
	 * @return
	 * @throws UserExistException
	 */
	public boolean findUserByName(String username) throws UserExistException;
	
}
