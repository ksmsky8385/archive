package mini_project_09_추상클래스_1;

public class MainClass {
	public static void main(String[] args) {
		
		LunchMenu student1 = new Student1(Price.rice, Price.bulgogi, Price.banana, Price.milk, Price.almond);
		LunchMenu student2 = new Student2(Price.rice, Price.bulgogi, Price.banana, Price.milk, Price.almond);		
	
		System.out.println("학생1의 식비는 " + student1.Total() + "원 입니다.");
		System.out.println("학생2의 식비는 " + student2.Total() + "원 입니다.");
		
	}
}
