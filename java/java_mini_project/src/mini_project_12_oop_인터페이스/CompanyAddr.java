package mini_project_12_oop_인터페이스;

import java.util.Scanner;

public class CompanyAddr extends Addr {
    private String companyName;
    private String department;
    private String position;

    public CompanyAddr(String name, String number, String email, String address, String birth, String group) {
        super(name, number, email, address, birth, group);

        if (group.equals("회사")) {
            @SuppressWarnings("resource") // 스캐너 안닫음 경고 무시
            Scanner sc = new Scanner(System.in);
            System.out.print("회사이름: ");
            this.companyName = sc.nextLine();
            System.out.print("부서명: ");
            this.department = sc.nextLine();
            System.out.print("직급: ");
            this.position = sc.nextLine();
        }
    }


    @Override
    public String getGroup() {
        if (super.getGroup().equals("회사")) {
            return "회사\n회사이름: " + companyName + "\n부서이름: " + department + "\n직급: " + position;
        }
        return super.getGroup();
    }
}