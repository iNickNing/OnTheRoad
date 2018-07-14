package top.inick.ThreadLoal;

import org.junit.Test;

public class TestThreadLocal {
	
	@Test
	public void test() {
		ThreadLocal tl = new ThreadLocal();
		tl.set("p");
		
		MyThread mt = new MyThread(tl);
		mt.start();
		
		System.out.println(tl.get() + "99999999999");
	}
}
