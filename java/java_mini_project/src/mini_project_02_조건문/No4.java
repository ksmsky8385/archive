package mini_project_02_조건문;

import java.util.Scanner;

public class No4 {

	public static void main(String[] args) {
		
		System.out.println("\n4번 : 두 값의 차 판별\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수 a :");
		int a = scanner.nextInt();
		System.out.println("정수 b :");
		int b = scanner.nextInt();
		
		System.out.printf("%s",(a-b>10 || b-a>10) ? "두값의 차이는 10이상입니다" : "두값의 차이는 9이하입니다");
		
		scanner.close();
		
	}

}
