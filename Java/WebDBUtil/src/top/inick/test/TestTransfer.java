package top.inick.test;

import top.inick.service.AccountService;
import top.inick.service.impl.AccountServiceImpl;

public class TestTransfer {
	public static void main(String[] args) throws Exception {
		AccountService as = new AccountServiceImpl();
		as.transfer("jack", "tom", 400);
		
	}
}
 	