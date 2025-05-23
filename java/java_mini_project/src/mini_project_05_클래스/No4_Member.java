package mini_project_05_클래스;

public class No4_Member {
	
	public static String name(String name){
		return name;
	}
	public static int age(int age) {
		return age;
	}
	
	public static double height(double height) {
		return height;
	}
	
	public static boolean hasBook(boolean hasBook) {
		return hasBook;
	}
	
	public static void checkVaccin(int age) {
		
		int birth = 2025 - age;
		
		System.out.println("나이 : " + age + ", 출생년도 : " + birth);
		
		if(age<13 || age>=60) {
			System.out.println("무료 예방접종이 가능합니다.");
		}
		else {
			System.out.println("무료 예방접종 대상이 아닙니다.");
		}
	}
		
	public static void healthCheck(int age) {
		
		int birth = 2025 - age;
		
		System.out.println("나이 : " + age + ", 출생년도 : " + birth);
		
		if(age>=20) {
			System.out.println("무료 건강검진 대상자 입니다.");
		}
		if(birth%2 ==0) {
			System.out.println("무료 건강검진이 가능한 해 입니다.");
		}
		else {
			System.out.println("무료 건강검진이 불가능한 해 입니다.");
		}
		if(age>=40) {
			System.out.println("무료 암 검사도 가능합니다.");
		}
	}
	
	
	public static void main(String[] args) {

	    String name = "자바";
	    int age = 45;
	    double height = 180;
	    boolean hasBook = true;
	    
	    System.out.println("나의 이름은 " + name + " 입니다." );
	    System.out.println("나이는 " + age + " 입니다. 키는 " + height + " cm 입니다. '이것이 자바다' 책을 가지고 있습니다. " + hasBook);
		checkVaccin(age);
		healthCheck(age);
	    
	    
	}
	
}
	
	



