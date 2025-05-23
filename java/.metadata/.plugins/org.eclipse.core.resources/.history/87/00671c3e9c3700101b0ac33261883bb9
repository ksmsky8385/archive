package mini_project_07_클래스;

class No5_Member {
	
	String name;
	String phone;
	String mayjor;
	int year;
	String email;
	String birth;
	String address;
	
	void info() {
		System.out.println("이름 : " + name + "\n전화번호 : " + phone + "\n전공 : " + mayjor + "\n학년 : " + year + "\n이메일 : " + email + "\n생일 : " + (birth != null ? birth : "정보없음") + "\n주소 : " + (address != null ? address : "정보없음"));
	}
	
	No5_Member(String name, String phone, String mayjor, int year, String email, String birth, String address) {
		
		this.name = name;
		this.phone = phone;
		this.mayjor = mayjor;
		this.year = year;
		this.email = email;
		this.birth = birth;
		this.address = address;
		
	}
	
	No5_Member(String name, String phone, String mayjor, int year, String email) {
		
		this.name = name;
		this.phone = phone;
		this.mayjor = mayjor;
		this.year = year;
		this.email = email;

	}
	
	
	public static void main(String[] args) {
		No5_Member m1 = new No5_Member("SHKIM", "010-9999-7777", "컴퓨터", 2, "shkim@gmail.com", "2000-10-11", "서울");
		No5_Member m2 = new No5_Member("강승민", "010-7659-8395", "기계공학과", 4, "ksmsky8385@naver.com");
		
		
		
		m1.info();
		System.out.println("------------------------------");
		m2.info();
	}

}
