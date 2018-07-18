package top.inick.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XMQ {

	public static void main(String[] args) {
		//PJL pjl = new PJL();
		//YPX ypx = new YPX();
		//KindWomen wp = new WP(ypx);
		//wp.throwEye();
		
		final KindWomen kw = new PJL();
		KindWomen poxy = (KindWomen) Proxy.newProxyInstance(kw.getClass().getClassLoader(), kw.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println(methodName);
				System.out.println("拿了钱");
				Object o = method.invoke(kw, new Object[] {(Double)args[0]/2});
				System.out.println("后面的事情");
				return o;
			}
		});
		
		poxy.throwEye(333);
	}

}
