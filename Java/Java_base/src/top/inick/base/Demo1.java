package top.inick.base;

import static java.lang.System.out;	//æ≤Ã¨µº»Î

import java.util.Arrays;
public class Demo1 {

	public static void main(String[] args) {
		out.print("aaa");
		String[] ss = {"aa", "bb", "cc"};
		
		Arrays.sort(ss);
		
		for (String string : ss) {
			out.print(string);
		}
	}
}
