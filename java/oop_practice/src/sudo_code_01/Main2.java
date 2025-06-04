package sudo_code_01;

public class Main2 {
    public static void main(String[] args) {
    	
    	Student[] students = {
    		    new Student("홍길동"),
    		    new Student("홍길서"),
    		    new Student("홍길남")
    		};

        Course[] courses = {
        		new Course("Software Engineering"), 
        		new Course("Design Pattern")
        };
        
    	String[] grades = {
    			"A+",
    			"B+",
    			"C+",
    			"D+"
    	};

        Transcript[] transcripts = {
        		new Transcript(students[0], courses[0]),
        		new Transcript(students[1], courses[1]),
        		new Transcript(students[2], courses[1])
        };
        
        transcripts[0].setGrade(grades[0]);
        transcripts[1].setGrade(grades[2]);
        transcripts[2].setGrade(grades[0]);
        
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName());
        }
        
        for (int i = 0; i < courses.length; i++) {
            System.out.println(courses[i].getName());
        }
        
        for (int i = 0; i < transcripts.length; i++) {
            System.out.println(transcripts[i].getStudent().getName()
            		+ " " + transcripts[i].getCourse().getName()
            		+ " " + transcripts[i].getGrade());
        }

    }
    
}