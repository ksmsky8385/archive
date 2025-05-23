package mini_project_08_oop_상속;

import java.util.Scanner;

public class CustomerAddr extends Addr {
	private String customerName;
    private String product;
    private String position;

    public CustomerAddr(String name, String number, String email, String address, String birth, String group) {
        super(name, number, email, address, birth, group);

        if (group.equals("거래처")) {
            @SuppressWarnings("resource") // 스캐너 안닫음 경고 무시
            Scanner sc = new Scanner(System.in);
            System.out.print("거래처이름: ");
            this.customerName = sc.nextLine();
            System.out.print("거래품목: ");
            this.product = sc.nextLine();
            System.out.print("직급: ");
            this.position = sc.nextLine();
        } else {
            this.customerName = "";
            this.product = "";
            this.position = "";
        }
    }


    @Override
    public String getGroup() {
        if (super.getGroup().equals("거래처")) {
            return "거래처\n거래처이름: " + customerName + "\n부서이름: " + product + "\n직급: " + position;
        }
        return super.getGroup();
    }
}

