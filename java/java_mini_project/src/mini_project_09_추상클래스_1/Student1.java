package mini_project_09_추상클래스_1;

public class Student1 extends LunchMenu {
	
	public Student1(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
	}
	
	@Override
	public int Total() {
		return rice + bulgogi + banana;
	}
	
}

