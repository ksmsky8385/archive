package sudo_code_01;

public class Main {
    public static void main(String[] args) {
    	
        Student student1 = new Student("홍길동");
        Student student2 = new Student("홍길서");
        Student student3 = new Student("홍길남");

        Course course1 = new Course("Software Engineering");
        Course course2 = new Course("Design Pattern");
        
    	String grade1 = "A+";
    	String grade2 = "C+";
        
        Transcript trans1 = new Transcript(student1, course1);
        Transcript trans2 = new Transcript(student2, course2);
        Transcript trans3 = new Transcript(student3, course2);
        
        trans1.setGrade(grade1);
        trans2.setGrade(grade2);
        trans3.setGrade(grade1);
        
        
        student1.registerCourse(course1);
        student2.registerCourse(course2);
        student3.registerCourse(course2);
        
        System.out.println(course1.getName());
        System.out.println(course2.getName());
        
        System.out.println(student1.getName());
        System.out.println(student2.getName());
        System.out.println(student3.getName());

        System.out.println(trans1.getStudent().getName() + " " + trans1.getCourse().getName() + " " + trans1.getGrade());
        System.out.println(trans2.getStudent().getName() + " " + trans2.getCourse().getName() + " " + trans2.getGrade());
        System.out.println(trans3.getStudent().getName() + " " + trans3.getCourse().getName() + " " + trans3.getGrade());

    }
    
}