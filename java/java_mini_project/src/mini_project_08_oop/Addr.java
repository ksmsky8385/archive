package mini_project_08_oop;

public class Addr {
	
	private String name;
	private String number;
	private String email;
	private String address;
	private String group;
	
	public Addr(String name, String number, String email, String address, String group) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.address = address;
		this.group = group;
	}
	
	public void printAddr() {
		System.out.printf("\n이름 : %s\n전화번호 : %s\n이메일 : %s\n주소 : %s\n그룹(친구/가족) : %s\n", name, number, email, address, group);
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
	
	public String getGroup() {
		return group;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}

}
