package mini_project_01_흐름제어;

import java.util.Scanner;

public class No3 {

	public static void main(String[] args) {
		
		System.out.println("\n3번 : 입력한 정숫값의 마지막자리 제외값 & 마직막자리값\n");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수값:");
		int a = scanner.nextInt();

	    int i = a / 10; // 마지막 자리 제외한 값
	    int j = a % 10; // 마지막 자리 숫자

	    System.out.println("마지막 자릿수를 제외한 값은 " + i + "입니다.");
	    System.out.println("마지막 자릿수는 " + j + "입니다.");

		scanner.close();
		
	}

}
