package top.inick.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import top.inick.domain.Account;
import top.inick.service.AccountService;
import top.inick.service.impl.AccountServiceImpl;

public class ObjectFactory {
	public static AccountService getAccountService() {
		AccountService as = new AccountServiceImpl();
		AccountService proxy = (AccountService) Proxy.newProxyInstance(as.getClass().getClassLoader(), as.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object invoke = null;
				try {
					ThreadLocalManager.starTransaction();
					invoke = method.invoke(as, args);
					ThreadLocalManager.commit();
				} catch (Exception e) {
					try {
						ThreadLocalManager.rollback();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				} finally {
					try {
						ThreadLocalManager.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return invoke;
			}
		});
		return proxy;
	}
}
