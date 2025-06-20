package mini_project_08_oop_상속;

import java.util.Scanner;

public class SmartPhone {
    static Addr[] addr = new Addr[10]; // 최대 10개 연락처 저장
    static int total = 0; // 현재 저장된 연락처 개수

    // 사용자 입력을 받는 메서드
    public static Addr inputAddrData() {
        @SuppressWarnings("resource") // 스캐너 안닫음 경고 무시
        Scanner sc = new Scanner(System.in);
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("전화번호: ");
        String number = sc.nextLine();
        System.out.print("이메일: ");
        String email = sc.nextLine();
        System.out.print("주소: ");
        String address = sc.nextLine();
        System.out.print("생일: ");
        String birth = sc.nextLine();
        System.out.print("그룹: ");
        String group = sc.nextLine();
        
        if(group.equals("회사")) {
        	return new CompanyAddr(name, number, email, address, birth, group);
        }
        else if(group.equals("거래처")) {
        	return new CustomerAddr(name, number, email, address, birth, group);
        }
        else;
        return new Addr(name, number, email, address, birth, group);
    }

    // 연락처 추가 메서드
    public void addAddr(Addr newAddr) {
        if (total >= addr.length) {
            System.out.println("연락처는 10개 이상 저장할 수 없습니다.");
            return;
        }
        
        if (newAddr instanceof CompanyAddr) {
            CompanyAddr companyAddr = (CompanyAddr) newAddr;
            newAddr = new CompanyAddr(
                companyAddr.getName(), companyAddr.getNumber(), companyAddr.getEmail(), companyAddr.getAddress(),
                companyAddr.getBirth(), companyAddr.getGroup());
        }
        
        else if (newAddr instanceof CustomerAddr) {
        	CustomerAddr customerAddr = (CustomerAddr) newAddr;
            newAddr = new CustomerAddr(
            	customerAddr.getName(), customerAddr.getNumber(), customerAddr.getEmail(), customerAddr.getAddress(),
            	customerAddr.getBirth(), customerAddr.getGroup());
        }
        
        addr[total] = newAddr;
        total++;
        System.out.println("\n주소록에 연락처가 추가되었습니다!");
    }

    // 연락처 출력 메서드
	public void printAddr(Addr addr) {
		System.out.printf("\n이름: %s\n전화번호: %s\n이메일: %s\n주소: %s\n생일: %s\n그룹: %s\n", 
		        addr.getName(), addr.getNumber(), addr.getEmail(), addr.getAddress(), addr.getBirth(), addr.getGroup());
		}

    
    // 모든 연락처 출력
    public void printAllAddr() {
        if (total == 0) {
            System.out.println("저장된 연락처가 없습니다.");
            return;
        }
        System.out.println("\n**연락처 목록**");
        for (int i = 0; i < total; i++) {
            System.out.print("------------------------");
            printAddr(addr[i]);
        }
        System.out.println("------------------------");
    }

    // 연락처 검색
    public void searchAddr(String name) {
        boolean found = false;
        for (int i = 0; i < total; i++) {
            if (addr[i].getName().equals(name)) {
                System.out.println("\n검색 결과:");
                printAddr(addr[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("연락처를 찾을 수 없습니다.");
        }
    }

    // 연락처 삭제
    public void deleteAddr(String name) {
        for (int i = 0; i < total; i++) {
            if (addr[i].getName().equals(name)) {
                for (int j = i; j < total - 1; j++) {
                    addr[j] = addr[j + 1]; // 배열 요소 이동하여 삭제
                }
                addr[total - 1] = null; // 마지막 요소 삭제
                total--;
                System.out.println("연락처가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("삭제할 연락처를 찾을 수 없습니다.");
    }

    // 연락처 수정
    public void editAddr(String name, Addr newAddr) {
        for (int i = 0; i < total; i++) {
            if (addr[i].getName().equals(name)) {
                addr[i] = newAddr;
                System.out.println("연락처가 업데이트되었습니다.");
                return;
            }
        }
        System.out.println("수정할 연락처를 찾을 수 없습니다.");
    }
}