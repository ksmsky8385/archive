package mini_project_02_조건문;

import java.util.Scanner;

public class No3 {

	public static void main(String[] args) {

		System.out.println("\n3번 : 3으로 나눈 값 표시\n");
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수값 :");
		int a = scanner.nextInt();
		
		if(a%3 == 1){
			System.out.println("이 값을 3으로 나눈 나머지는 1입니다.");
		
	}
		else if(a%3 == 2) {
			System.out.println("이 값을 3으로 나눈 나머지는 2입니다.");
		}
		else if(a%3 == 0) {
			System.out.println("이 값은 3으로 나누어집니다.");
			}
		else if(a<0){
			System.out.println("양수가 아닌 값을 입력했네요.");
		}
		
		scanner.close();
		
		}
}
