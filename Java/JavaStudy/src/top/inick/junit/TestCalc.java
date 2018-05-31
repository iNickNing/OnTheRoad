package top.inick.junit;

import org.junit.Test;

import org.junit.Assert;

//注:测试方法要求:不能有返回值,不能有参数
public class TestCalc {

	@Test
	public void test1() {
		Calc c = new Calc();
		Assert.assertEquals(3, c.div(10, 3), 0.4);
	}
	
}
