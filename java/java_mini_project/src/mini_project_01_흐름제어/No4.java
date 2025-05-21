package mini_project_01_흐름제어;

import java.util.Scanner;

public class No4 {

	public static void main(String[] args) {
		
		System.out.println("\n4번 : 두 실수의 합과 평균\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("x 값:");
		double a = scanner.nextDouble();
		
		System.out.println("y 값:");
		double b = scanner.nextDouble();
		
		System.out.println("합계는 "+(a+b)+"입니다.");
		System.out.println("평균은 " + (a+b)/2 + "입니다.");
		
		scanner.close();

	}

}
