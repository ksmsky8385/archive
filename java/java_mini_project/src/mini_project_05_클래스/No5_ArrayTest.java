package mini_project_05_클래스;

import java.util.Scanner;

public class No5_ArrayTest {

	public static void main(String[] args) {
		
		No5_Member_2[] members = new No5_Member_2[5];
		
		members[0] = new No5_Member_2(1, "aaa", "임영웅");
		members[1] = new No5_Member_2(2, "bbb", "영탁");
		members[2] = new No5_Member_2(3, "ccc", "손흥민");
		members[3] = new No5_Member_2(4, "ddd", "박지성");
//		members[4] = new No6_Member(5, "eee", "차두리");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("회원번호 : ");
		int a = Integer.parseInt(scan.nextLine());
		System.out.print("아이디 : ");
		String b = scan.nextLine();
		System.out.print("이름 : ");
		String c = scan.nextLine();
		
		members[4] = new No5_Member_2(a, b, c);
		

		
		for(int i = 0; i < members.length; i++) {
			System.out.printf("%d번 회원의 아이디는 %s 이고, 이름은 %s 입니다.\n", 
					members[i].memberNo, members[i].memberId, members[i].memberName);
		}
		
		
		scan.close();
	}

}
