package mini_project_02_조건문;

import java.util.Scanner;

public class No5 {

	public static void main(String[] args) {
		
		System.out.println("\n5번 : 두 정수값을 내림차순으로 정렬\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수 A :");
		int a = scanner.nextInt();
		System.out.println("정수 B :");
		int b = scanner.nextInt();
		
		int c = 0;
		
		if(a<b) {
			c = a;
			a = b;
			b = c;
		}

		System.out.printf("변수 a는 %d입니다\n변수 b는 %d입니다.", a,b);
		
		scanner.close();
		
	}

}
