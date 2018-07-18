package top.inick.annotation;

public class SomeDaoImpl {
	
	@MyTest(timeout=1000)
	public void testAdd() {
		System.out.println("add");
	}

	public void testUpdate() {
		System.out.println("update"
				+ "");
	}
}
