package top.inick.base;

public class Demo4 {
	public static void main(String[] args) {
		//System.out.println(sum(1,2,3,4,5));
		m1("q","e");
		m1("q","e");
		m1("q","e","eee");
	}
	
	public static void m1(String a, String b){
		System.out.println("aaaaaaa");
	}

	public static void m1(String ... b){
		System.out.println("bbbbbb");
	}
	
	public static int sum(int ... nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
}
