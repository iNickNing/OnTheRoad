package top.inick.base;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		//JDK 5.0 之前
		/*Integer i = 10;		//1.5之前不能用
		Integer i2 = new Integer(10);
		Integer i3 = Integer.valueOf(10);
		
		int ii = i3;		//1.5之前也不能用
		int ii2 = i.intValue();*/
		
/*		Integer i = 10;
		int i1 = i;*/
		
		List list = new ArrayList();
/*		list.add(new Integer(10));	//5.0之前
		int i = ((Integer)list.get(0)).intValue();*/
		
/*		list.add(10);
		int i = (Integer)list.get(1);*/
		
		/*Integer i = null;
		int j = i;*/
		
		Integer i1 = 129;
		Integer i2 = 129;
		Integer i3 = 258;
		System.out.println(i1 == i2);
		System.out.println(i3 == (i1 + i2));
	}
}
