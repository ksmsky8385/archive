package mini_project_05_클래스;

public class No7_Account {
	
	private String name;
	private int no;
	private int balance;
	int input;
	
	public No7_Account(String name, int no, int balance) {
		this.name = name;
		this.no = no;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int deposit(int input) {
		balance -= input;
		return balance;
	}
	
}
