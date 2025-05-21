package mini_project_01_흐름제어;

import java.util.Scanner;

public class No1 {

	public static void main(String[] args) {
		
		System.out.println("1번 : 입력한 정숫값을 표시\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수값:");
		int inputData = scanner.nextInt();
		
		System.out.println( inputData + "을(를) 입력했습니다.");
		
        scanner.close();
		
	}

}
