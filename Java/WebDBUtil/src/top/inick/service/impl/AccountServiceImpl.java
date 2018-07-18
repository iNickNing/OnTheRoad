package top.inick.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import top.inick.dao.AccountDao;
import top.inick.dao.impl.AccountDaoImpl;
import top.inick.domain.Account;
import top.inick.service.AccountService;
import top.inick.util.C3P0Utils;
import top.inick.util.ThreadLocalManager;

public class AccountServiceImpl implements AccountService {

	@Override
	public void transfer(String fromname, String toname, double money) throws Exception {
		//ad.updateAccount(fromname, toname, money);
		//Connection conn = C3P0Utils.getConnection();
		AccountDao ad = new AccountDaoImpl();

		//分别盗盗转出和转入的账户对象
		Account fromAccount = ad.findAccountByName(fromname);
		Account toAccount = ad.findAccountByName(toname);
		
		//修改账户信息的金额
		fromAccount.setMoney(fromAccount.getMoney() - money);
		toAccount.setMoney(toAccount.getMoney() + money);
		
		//完成转账操作
		ad.updateAccount(fromAccount);
		ad.updateAccount(toAccount);

	}

}
