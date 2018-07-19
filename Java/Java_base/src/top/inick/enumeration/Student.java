package top.inick.enumeration;

public class Student {
	
	private String name;
	private Grade grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Student(String name, Grade grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

enum Grade {
	A("100-90"){
		public String toLocaleGrade() {
			return "优";
		}
	},B("89-80"){
		public String toLocaleGrade() {
			return "良";
		}
	},C("79-70"){
		public String toLocaleGrade() {
			return "一般";
		}
	},D("69-60"){
		public String toLocaleGrade() {
			return "及格";
		}
	},E("59-0"){
		public String toLocaleGrade() {
			return "不及格";
		}
	};
	
	private Grade(String score) {
		this.score = score;
	}
	
	private String score;

	public String getScore() {
		return score;
	}
	
	public abstract String toLocaleGrade();
}
