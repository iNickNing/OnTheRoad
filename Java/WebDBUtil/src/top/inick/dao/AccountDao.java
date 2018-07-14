package top.inick.dao;

import java.sql.Connection;

import top.inick.domain.Account;

public interface AccountDao {
	/**
	 * 转账
	 * @param fromname	转出账户
	 * @param toname	接收账户
	 * @param money		转账金额
	 */
	@Deprecated
	public void updateAccount(String fromname, String toname, double money) throws Exception;
	/**
	 * 根据用户信息修改金额
	 * @param account
	 * @throws Exception
	 */
	public void updateAccount(Account account) throws Exception;

	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name) throws Exception;
}

