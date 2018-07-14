package top.inick.dao.impl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import top.inick.dao.AccountDao;
import top.inick.domain.Account;
import top.inick.util.C3P0Utils;

public class AccountDaoImpl implements AccountDao {

	private Connection conn;
	
	
	@Override
	public void updateAccount(String fromname, String toname, double money) throws Exception {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		qr.update("update account set money=money-? where name=?",money,fromname);
		qr.update("update account set money=money+? where name=?",money,toname);
	}

	@Override
	public void updateAccount(Account account) throws Exception {
		QueryRunner qr = new QueryRunner();
		qr.update(conn,"update account set money=? where name=?",account.getMoney(), account.getName());
	}

	@Override
	public Account findAccountByName(String name) throws Exception {
		QueryRunner qr = new QueryRunner();
		return qr.query(conn,"select * from account where name=?", new BeanHandler<Account>(Account.class), name);
	}

}
