package mini_project_03_반복문;

import java.util.Scanner;

public class No3 {

	public static void main(String[] args) {
		
		System.out.println("\n3번 : 1부터 입력받은 양의 정수까지의 곱 출력\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("양의 정수값 :");
		int a = scanner.nextInt();
		int b = 1;
		
		for(int i = 1; i<=a; i++) {
			b*=i;
		}
		
		System.out.printf("1부터 %d까지의 곱은 %d입니다.", a,b);
		
		scanner.close();

	}

}
