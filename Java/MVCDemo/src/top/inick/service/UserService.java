package top.inick.service;

import top.inick.domain.User;

public interface UserService {
	/**
	 * 添加(注册)用户信息
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
}
