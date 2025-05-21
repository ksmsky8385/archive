package mini_project_02_조건문;

import java.util.Scanner;

public class No1 {

	public static void main(String[] args) {
		
		System.out.println("\n1번 : 정수값을 읽어서 절대값 구하기\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수값:");
		int a = scanner.nextInt();
		
		if(a <0) {
			int b =  a  * -1;
			System.out.println("절대값은 " + b + "입니다.");
		}
		else {
			System.out.println("절대값은 " + a + "입니다.");
		}
		
		scanner.close();
		
	}

}
