package mini_project_11_인터페이스;

public class APhone implements IFunction {
	
	private int generation;
	
	public void phoneName() {
		System.out.println("A Phone");
	}
	
	public void call() {
		System.out.println("전화 가능합니다.");
	}
	
	public void thisGen(int generation) {
		if(generation>3) {
			this.generation = generation;
			System.out.println("가능합니다. " + generation + "G 입니다.");
		}
		else {
			this.generation = generation;
			System.out.println("불가능합니다. " + generation + "G 입니다.");
		}
	}
	
	public void remoteTV() {
		System.out.println("미탑재 되어 있습니다.");
	}

}
