package mini_project_01_흐름제어;
import java.util.Scanner;

public class No5 {
	public static void main(String[] args) {
		
		System.out.println("\n5번 : 이름과 나이를 입력받기\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요:");
		String name = scanner.nextLine();
		
		System.out.println("나이를 입력하세요:");
		int age = scanner.nextInt();
		
		System.out.println(name+" 님 안녕하세요! "+age+"살 이네요!");
		
		scanner.close();
		
	}
}
