package mini_project_04_배열;

import java.util.Scanner;

public class No4 {

	public static void main(String[] args) {
		
		System.out.println("\n4번 : 3명의 영어&수학점수의 평균값들 출력\n");
		
		Scanner scanner = new Scanner(System.in);
		
		int[] En = new int[3];
		int[] Ma = new int[3];
		int sumE = 0;
		int sumM = 0;
		
		
		System.out.println("3명의 영어, 수학 점수를 입력하세요.");
		for(int i = 0; i<3; i++) {
			System.out.print((i+1) + "번");
			System.out.print(" 영어 :");
			int a = scanner.nextInt();
			En[i] = a;
			sumE += a;
			System.out.print(" 수학 :");
			int b = scanner.nextInt();
			Ma[i] = b;
			sumM += b;
		}
		double avgE = (double) sumE/3;
		double avgM = (double) sumM/3;
		
	    System.out.println("No.  영어  수학  평균");
		for (int i = 0; i<3; i++) {
		    System.out.printf(" %d       %d     %d     %.1f \n",(i+1),En[i],Ma[i], (double) (En[i] + Ma[i])/2);
		}
		System.out.printf("평균 %.1f  %.1f", avgE, avgM);

		scanner.close();

	}

}
