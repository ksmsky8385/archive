package sudo_code_01;

import java.util.Vector;

public class Student {
	private String name;
	private Vector<Course> courses;

	public Student(String name) {
		this.name = name;
		courses = new Vector<Course>();
	}

	public void registerCourse(Course course) {
		courses.add(course);
		
	}
		
	public void dropCourse(Course course) {
		if(courses.contains(course)) {
			courses.remove(course);
		}
	}
	
	public Vector<Course> getCourse() {
		return courses;
	}
	
	public String getName() {
		return name;
	}
	
	public void addTranscript(Transcript transcript) {

	}
	
}
