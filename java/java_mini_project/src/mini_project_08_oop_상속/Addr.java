package mini_project_08_oop_상속;

public class Addr {
	
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

}
