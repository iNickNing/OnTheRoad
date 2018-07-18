package top.inick.test;

import top.inick.service.AccountService;
import top.inick.service.impl.AccountServiceImpl;
import top.inick.util.ObjectFactory;

public class TestTransfer {
	public static void main(String[] args) throws Exception {
		//AccountService as = new AccountServiceImpl();
		AccountService as = ObjectFactory.getAccountService();
		as.transfer("tom", "jack", 400);
		
	}
}
 	