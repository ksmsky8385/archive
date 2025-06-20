package mini_project_12_oop_인터페이스;

public class Addr implements ShowData {
	
	private String name;
	private String number;
	private String email;
	private String address;
	private String birth;
	private String group;
	
	public Addr(String name, String number, String email, String address, String birth, String group) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.group = group;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public String getGroup() {
		return group;
	}
	
	
	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + number);
	}

}
