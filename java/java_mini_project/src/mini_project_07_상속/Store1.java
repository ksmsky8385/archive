package mini_project_07_상속;

public class Store1 extends Hqstore {
	
	@Override
	protected void whatStoreMenu() {
		System.out.println("1호점 가격표입니다.");
		}
	@Override
	protected void jajangmyeon() {
		System.out.println("자장면은 7,000원 입니다.");
	}
	@Override
	protected void gunmandu() {
		System.out.println("군만두는 판매하지 않습니다.");
		}
	
}
