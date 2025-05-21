package mini_project_03_반복문;

import java.util.Scanner;

public class No4 {

	public static void main(String[] args) {

		System.out.println("\n4번 : 입력받은 수 만큼 *을 5개 당 줄바꿈 출력\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("몇 개의 *를 표시할까요? :");
		int a = scanner.nextInt();
		
		int i = 0;
        while (i < a) {
            System.out.print("*"); 
            i++;
		
		   if (i % 5 == 0) {
               System.out.println();
		   }
        }
        
		scanner.close();
		   
	}

}