package mini_project_04_배열;

import java.util.Random;
import java.util.Scanner;

public class No3 {

	public static void main(String[] args) {
		
		System.out.println("\n3번 : 인덱스 수 입력 후 1~10난수 대입\n");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("인덱스 수 :");
		int b = scanner.nextInt();
		int[] a = new int[b];
		Random rand = new Random();
		
		for(int i = 0; i<b; i++) {
			a[i] = rand.nextInt(10)+1;
			System.out.println("a[" + i + "] = " + a[i]);
		}
		
		scanner.close();
		
	}

}
