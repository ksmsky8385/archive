package mini_project_07_상속;

public class MainClass {
	public static void main(String[] args) {
		
		Hqstore st = new Hqstore();
		st.printMenu();
		System.out.println("=======================");
		
		st = new Store1();
		st.printMenu();
		System.out.println("=======================");
		
		st = new Store2();
		st.printMenu();
		System.out.println("=======================");
		
		st = new Store3();
		st.printMenu();
		
	}

}
