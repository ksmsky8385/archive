package mini_project_09_추상클래스_1;

public class Student2 extends LunchMenu {
	
	public Student2(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
	}
	
	@Override
	public int Total() {
		return rice + bulgogi + milk + almond;

	}
	
}