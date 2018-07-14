package top.inick.service;

public interface AccountService {
	/**
	 * 转账
	 * @param fromname	转出账户
	 * @param toname	接收账户
	 * @param money		转账金额
	 */
	public void transfer(String fromname, String toname, double money);
}
