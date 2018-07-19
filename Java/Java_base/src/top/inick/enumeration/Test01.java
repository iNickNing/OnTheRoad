package top.inick.enumeration;

public class Test01 {

	public static void main(String[] args) {
		Student s = new Student();
		s.setGrade(Grade.E);
		System.out.println(s.getClass().getName());
		System.out.println(s.getGrade().getScore() + s.getGrade().toLocaleGrade());
		
		Grade g = Grade.A;
		switch(g) {
		case A:
			System.out.println("aaaa");
			break;
		case B:
			System.out.println("bbbb");
			break;
		default:
			System.out.println("other");
			break;
		} 
		
		for (Grade gg : Grade.values()) {
			System.out.println(gg + "--" + gg.ordinal());
		}
	}

}
