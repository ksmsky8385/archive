package mini_project_03_반복문;

import java.util.Scanner;

public class No5 {
	
    public static void main(String[] args) {
    	
        System.out.println("\n5번 : 양의 정수값 입력 후 소수 판별\n");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("2 이상의 정수값 입력: ");
        int a = scanner.nextInt();

        boolean isPrime = true;

        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(a + "는 소수입니다.");
        } else {
            System.out.println(a + "는 소수가 아닙니다.");
        }

        scanner.close();
    }
}