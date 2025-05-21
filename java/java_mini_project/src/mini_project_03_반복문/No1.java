package mini_project_03_반복문;

import java.util.Scanner;

public class No1 {

	public static void main(String[] args) {
		
		System.out.println("\n1번 : 두 정수값 사이의 모든 정수값 오름차순 출력\n");

		Scanner scanner = new Scanner(System.in);

		System.out.println("정수 A :");
		int a = scanner.nextInt();
		System.out.println("정수 B :");
		int b = scanner.nextInt();
		
		int num = a;
		if(a>b) {
			num = b;
		}
		
		do {
			System.out.printf("%d\n", num++);
		}
		while(num <= a || num <= b);
		
		scanner.close();
		
	}

}
