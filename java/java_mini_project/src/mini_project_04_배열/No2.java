package mini_project_04_배열;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		
		System.out.println("\n2번 : 시험 점수의 합계,평균,최고점,최저점 출력\n");

		Scanner scanner = new Scanner(System.in);
		


		System.out.println("사람 수는 몇명 :");
		int a = scanner.nextInt();
		int[] score = new int[a];
		System.out.println("점수를 입력하세요 :");
		
		int sum = 0;
		int max = 0;
        int min = 100;
        
		for(int i = 0; i<a; i++) {
			System.out.print((i+1) + "번의 점수 : ");
			int b = scanner.nextInt();
			score[i] = b;
			sum += score[i];
            if (score[i] > max) {
                max = score[i];
            }
            if (score[i] < min) {
                min = score[i];
            }


		}
		
		double avg = (double) sum/a;

		System.out.println("합계는 " + sum + "점 입니다.");
		System.out.println("평균은 " + avg + "점 입니다.");
		System.out.println("최고점은  " + max + "점 입니다.");
		System.out.println("최저점은  " + min + "점 입니다.");

		
		scanner.close();
		

	}

}
