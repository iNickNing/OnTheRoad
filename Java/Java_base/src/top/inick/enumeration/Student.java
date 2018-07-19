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
			return "��";
		}
	},B("89-80"){
		public String toLocaleGrade() {
			return "��";
		}
	},C("79-70"){
		public String toLocaleGrade() {
			return "һ��";
		}
	},D("69-60"){
		public String toLocaleGrade() {
			return "����";
		}
	},E("59-0"){
		public String toLocaleGrade() {
			return "������";
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
