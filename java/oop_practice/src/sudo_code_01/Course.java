package sudo_code_01;

import java.util.Vector;

public class Course {
	private String name;
	private Vector<Student> students;
	
	public Course(String name) {
		this.name = name;
		students = new Vector<Student>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addStudent(Student name) {
		students.add(name);
	}
	
	public void removeStudent(Student name) {
		if(students.contains(name)) {
			students.remove(name);
		}
	}
	
	public Vector<Student> getStudent() {
		return students;
	}
	
	public void addTranscript(Transcript transcript) {
		
	}
	
}
