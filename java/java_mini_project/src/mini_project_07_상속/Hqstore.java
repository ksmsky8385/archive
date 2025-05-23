package mini_project_07_상속;

public class Hqstore {
	
	protected void whatStoreMenu() {
		System.out.println("본점 가격표입니다.");
		}
	
	protected void jajangmyeon() {
		System.out.println("자장면은 8,000원 입니다.");
		}
	
	protected void jjamppong() {
		System.out.println("짬뽕은 8,000원 입니다.");
		}
	
	protected void tangsuyuk() {
		System.out.println("탕수육은 12,000원 입니다.");
		}
	
	protected void gunmandu() {
		System.out.println("군만두는 3,000원 입니다.");
		}
	
	protected void gonggibab() {
		System.out.println("공기밥은 1,000원 입니다.");
		}
	
	protected void printMenu() {
		whatStoreMenu();
		jajangmyeon();
		jjamppong();
		tangsuyuk();
		gunmandu();
		gonggibab();
	}
	
}
