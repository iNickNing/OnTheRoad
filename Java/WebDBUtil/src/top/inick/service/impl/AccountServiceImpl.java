package top.inick.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import top.inick.dao.AccountDao;
import top.inick.dao.impl.AccountDaoImpl;
import top.inick.domain.Account;
import top.inick.service.AccountService;
import top.inick.util.C3P0Utils;

public class AccountServiceImpl implements AccountService {

	@Override
	public void transfer(String fromname, String toname, double money) {
		//ad.updateAccount(fromname, toname, money);
		Connection conn = C3P0Utils.getConnection();
		AccountDao ad = new AccountDaoImpl();
		try {
			conn.setAutoCommit(false);//begin;
			
			//分别盗盗转出和转入的账户对象
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);
			
			//修改账户信息的金额
			fromAccount.setMoney(fromAccount.getMoney() - money);
			toAccount.setMoney(toAccount.getMoney() + money);
			
			//完成转账操作
			ad.updateAccount(fromAccount);
			ad.updateAccount(toAccount);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback(); //回滚事务
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
