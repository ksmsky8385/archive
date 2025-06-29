package mini_project_06_oop;

import java.util.Scanner;

public class SmartPhoneMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SmartPhone phone = new SmartPhone();
		
		while (true) {
		System.out.println("\n주소관리 메뉴---------\n>> 1. 연락처 등록\n>> 2. 모든 연락처 출력\n>> 3. 연락처 검색\n>> 4. 연락처 삭제\n>> 5. 연락처 수정\n>> 6. 프로그램 종료\n-------------------------");
		
		int selectnumber;
        while (true) {
            if (sc.hasNextInt()) {  // 숫자인지 확인
                selectnumber = sc.nextInt();
                sc.nextLine(); // 버퍼 클리어
                break;
            } else {
                sc.nextLine(); // 잘못된 입력 제거
                System.out.print("잘못된 입력입니다. 숫자를 입력하세요: ");
            }
        }

        switch (selectnumber) {
            case 1:
                Addr newAddr = SmartPhone.inputAddrData();
                phone.addAddr(newAddr);
                break;
            case 2:
                phone.printAllAddr();
                break;
            case 3:
                System.out.print("검색할 이름을 입력하세요: ");
                String name = sc.nextLine();
                phone.searchAddr(name);
                break;
            case 4:
                System.out.print("삭제할 이름을 입력하세요: ");
                String nameToDelete = sc.nextLine();
                phone.deleteAddr(nameToDelete);
                break;
            case 5:
                System.out.print("수정할 이름을 입력하세요: ");
                String nameToEdit = sc.nextLine();
                System.out.println("새 연락처 정보를 입력하세요:");
                Addr updatedAddr = SmartPhone.inputAddrData();
                phone.editAddr(nameToEdit, updatedAddr);
                break;
            case 6:
                System.out.println("프로그램을 종료합니다.");
                sc.close(); // Scanner 닫기
                return; // 프로그램 종료
            default:
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                
	        }
	    }
	}
}
