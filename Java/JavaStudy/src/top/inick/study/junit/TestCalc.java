package top.inick.study.junit;

import org.junit.Test;

import org.junit.Assert;

//ע:���Է���Ҫ��:�����з���ֵ,�����в���
public class TestCalc {

	@Test
	public void test1() {
		Calc c = new Calc();
		Assert.assertEquals(3, c.div(10, 3), 0.4);
	}
	
}
