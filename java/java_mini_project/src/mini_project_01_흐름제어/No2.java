package mini_project_01_흐름제어;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		
		System.out.println("\n2번 : 입력한 정숫값의 +100 , -100 값 출력\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수값:");
		int inputData = scanner.nextInt();
		
		System.out.println("100을 더한 값은 " + ( inputData+100) + "입니다.");
		System.out.println("100을 뺀 값은 " + ( inputData-100) + "입니다.");

        scanner.close();
		
	}

}
