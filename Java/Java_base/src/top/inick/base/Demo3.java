package top.inick.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo3 {
	public static void main(String[] args) {
		
		/*String[] ss = {"aa", "bb", "cc"};
		for(String s : ss) {
			s = "2b";
		}
		System.out.println(ss[1]);*/
		
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for (Object object : list) {
			String s = (String)object; 
			if(s.equals("bbb")) {
				list.remove(s);
			}
			System.out.println(s);
		}
		

	}

	private static void test3() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aaaaa5aaa");
		map.put("b", "aaaa45aaaa");
		map.put("aca", "aaaa2aaaa");
		
		for (String s : map.keySet()) {
			String value = map.get(s);
			System.out.println(s + "--" + value);
		}
		
		for(Map.Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
			
		}
	}

	private static void test2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aaaaa5aaa");
		map.put("b", "aaaa45aaaa");
		map.put("aca", "aaaa2aaaa");
		
/*		Set set = map.keySet();
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			String key = (String) ite.next();
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}*/
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator ite = entrySet.iterator();
		while(ite.hasNext()) {
			Entry<String, String> e = (Entry<String, String>)ite.next();
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key + ":" + value);
		}
	}

	private static void test1() {
		int[] arr = {3,5,6,7};
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		Set set = new HashSet();
		set.add("aaaaa");
		set.add("aaabaa");
		set.add("aaaeaa");
		set.add("aaacaa");
		
		for (Object object : set) {
			System.out.println(object);
		}
	}
}
