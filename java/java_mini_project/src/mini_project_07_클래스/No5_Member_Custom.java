package mini_project_07_클래스;

import java.util.Scanner;

class No5_Member_Custom {
	
	String name;
	String phone;
	String major;
	String year;
	String email;
	String birth;
	String address;
	
	void info() {
		System.out.println("이름 : " + name + "\n전화번호 : " + phone + "\n전공 : " + major + "\n학년 : " + year + "\n이메일 : " + email + "\n생일 : " + (birth != null ? birth : "정보없음") + "\n주소 : " + (address != null ? address : "정보없음"));
	}
	
	No5_Member_Custom(String name, String phone, String mayjor, String year, String email, String birth, String address) {
		
		this.name = name;
		this.phone = phone;
		this.major = mayjor;
		this.year = year;
		this.email = email;
		this.birth = birth;
		this.address = address;
		
	}
	
public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		System.out.print("이름 : ");
		String name = scan.nextLine();
		name = name.isEmpty() ? "정보없음" : name;

		System.out.print("전화번호 : ");
		String phone = scan.nextLine();
		while (phone.length() != 11 || !phone.matches("\\d+")) {
		    if (phone.isEmpty()) {
		        phone = "정보없음";
		        break;
		    }
		    System.out.println("11자리여야 합니다. 다시 입력하세요.");
		    System.out.print("전화번호 : ");
		    phone = scan.nextLine().trim();
		}
		if (phone.length() == 11) {
		    phone = String.format("%s-%s-%s", phone.substring(0, 3), phone.substring(3, 7), phone.substring(7));
		}


		System.out.print("전공 : ");
		String major = scan.nextLine();
		major = major.isEmpty() ? "정보없음" : major;

		System.out.print("학년 : ");
		String year = scan.nextLine();
		year = year.isEmpty() ? "정보없음" : year;

		System.out.print("이메일 : ");
		String email = scan.nextLine();
		email = email.isEmpty() ? "정보없음" : email;
		
		System.out.print("생일 : ");
		String birth = scan.nextLine();
		birth = birth.isEmpty() ? "정보없음" : birth;
		
		System.out.print("주소 : ");
		String address = scan.nextLine();
		address = address.isEmpty() ? "정보없음" : address;
				
		No5_Member_Custom m1 = new No5_Member_Custom(name, phone, major, year, email, birth, address);
		

		m1.info();
		
		scan.close();
	}

}
