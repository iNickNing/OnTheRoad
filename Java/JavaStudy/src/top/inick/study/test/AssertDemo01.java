package top.inick.study.test;

public class AssertDemo01 {

	public static void main(String[] args) {
		int i = 20;
		System.out.println("test");
		//如果布尔表达式的值为false ， 将抛出AssertionError 异常
		assert false: "failed";
		
		System.out.println("ok");
		
	}

}
