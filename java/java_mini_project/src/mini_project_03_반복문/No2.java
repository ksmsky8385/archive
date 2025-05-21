package mini_project_03_반복문;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {

		System.out.println("\n2번 : 입력받은 정수만큼 * 출력\n");
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("몇 개의 *를 표시할까요? :");
		int a = scanner1.nextInt();
		
		int i = 0;
        while (i < a) {
            System.out.print("*"); 
            i++;
        }
        
        scanner1.close();

	}

}
