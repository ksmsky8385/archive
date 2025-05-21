package mini_project_04_배열;

public class No1 {

	public static void main(String[] args) {
		
		System.out.println("\n1번 : 배열요소가 5인 int형 배열을 내림차순으로 출력\n");

		int[]a = new int[5];
		
		for(int i = 0; i<5; i++) {
			a[i] = 5-i;
		}
		for(int j = 0;  j<5; j++) {
				System.out.println("a[" + j + "]" + "= " + a[j] );
		}
		
	}

}
