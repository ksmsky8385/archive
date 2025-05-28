package mini_project_02_조건문;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		
		System.out.println("\n2번 : 두 양의 정수값 간의 약수판별\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("변수 A :");
		int a = scanner.nextInt();

		System.out.println("변수 B :");
		int b = scanner.nextInt();
		
		if(a%b == 0) {
			System.out.println("B는 A의 약수입니다.");
		}
		else {
			System.out.println("B는 A의 약수가 아닙니다.");
		}
		
		scanner.close();
		
	}

}
