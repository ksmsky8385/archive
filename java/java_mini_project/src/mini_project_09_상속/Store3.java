package mini_project_09_상속;

public class Store3 extends Hqstore {

	@Override
	protected void whatStoreMenu() {
		System.out.println("3호점 가격표입니다.");
		}
	@Override
	protected void jajangmyeon() {
		System.out.println("자장면은 7,000원 입니다.");
	}
	@Override
	protected void jjamppong() {
		System.out.println("짬뽕은 7,000원 입니다.");
	}
	
}

