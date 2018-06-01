package top.inick.test;

import org.junit.Assert;

public class AssertDemo01 {

	public static void main(String[] args) {
		int i = 20;
		System.out.println("test");
		//如果期望值不符， 将抛出AssertionError 异常
		Assert.assertEquals(23, i, 0.4);
		
		System.out.println("ok");
		
	}

}
