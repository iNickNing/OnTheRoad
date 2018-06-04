package top.inick.test;

import org.junit.Assert;

public class AssertDemo01 {

	public static void main(String[] args) {
		int i = 20;
		System.out.println("test");
		//�������ֵ������ ���׳�AssertionError �쳣
		Assert.assertEquals(20, i, 0.4);
		
		System.out.println("ok");
		
		int[] arr = {13, 4, 4};
		int[] arr2 = {5, 5, 45};
		test(arr,arr2);
		System.out.println(arr[0]);
	}

	public static void test(int[] arr, int[] arr2) {
		arr[0] = 90;
		arr = arr2;
	}
}
