package top.inick.test;

public class AssertDemo01 {

	public static void main(String[] args) {
		int i = 20;
		System.out.println("test");
		//����������ʽ��ֵΪfalse �� ���׳�AssertionError �쳣
		assert false: "failed";
		
		System.out.println("ok");
		
	}

}
