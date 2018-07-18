package top.inick.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01 {
	@SuppressWarnings({"unused", "deprecation", "rawtypes"})
	public void ff() {

		int i=2;
		
		List list = new ArrayList();
		
		System.out.println(new Date().toLocaleString());
	}
	
//	@MyAnnotation(age=19,name="tom")
	@MyAnnotation("aaa")
	public void ff2() {}
	
	public void ll11iil1() {}
}

class Demo02 extends Demo01{
	@Override
	public void ff() {
		System.out.println("lala");
	}
	
	@Deprecated
	public void ll11iil1() {}
	
}
