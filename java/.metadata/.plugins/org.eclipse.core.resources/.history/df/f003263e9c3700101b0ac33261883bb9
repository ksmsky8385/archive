package mini_project_07_클래스;

import java.util.Scanner;

public class No7_AccountMain {
	
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	System.out.println("계좌번호를 입력하세요");
	System.out.print("계좌명의 : ");
	String name = sc.nextLine();
	
	System.out.print("계좌번호 : ");
	int no = sc.nextInt();
	
	System.out.print("잔고 : ");
	int balance = sc.nextInt();
	
	No7_Account account = new No7_Account(name, no, balance);
	
	System.out.printf("계좌 기본 정보 : {%s, %d, %d}\n",account.getName(),account.getNo(),account.getBalance());
	
	System.out.print("출금액 : ");
	int input = sc.nextInt();
	account.deposit(input);
	
	System.out.println("잔금은 " + account.getBalance() + "원 입니다.");
	
	sc.close();
	
	}

}
