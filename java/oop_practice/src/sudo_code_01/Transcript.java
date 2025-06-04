package sudo_code_01;


public class Transcript {
	
	private Student student;
	private Course course;
	private String date;
	private String grade;
	
	
	public Transcript(Student student, Course course) {
		this.student = student;
		this.course = course;

	}
	
	public Student getStudent() {
		return student;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}

}