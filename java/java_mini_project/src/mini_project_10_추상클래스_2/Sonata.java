package mini_project_10_추상클래스_2;

public abstract class Sonata {
	String color;
	String tire;
	int displacement;
	String handle;
	
	public Sonata(String color, String tire, int displacement, String handle){
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	public int getSpec() {
		System.out.printf("색상: %s\n", color);
		System.out.printf("타이어: %s\n", tire);
		System.out.printf("배기량: %d\n", displacement);
		System.out.printf("핸들: %s\n", handle);
		return displacement;
	}
}
