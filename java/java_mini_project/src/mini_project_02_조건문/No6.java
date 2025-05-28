package mini_project_02_조건문;
import java.util.Random;

public class No6 {

	public static void main(String[] args) {
		
		System.out.println("\n6번 : 난수 생성 후 가위바위보 출력\n");
		
		Random rand = new Random();
		int test = rand.nextInt(3);
		
		System.out.println("컴퓨터가 낸 것은");
		
		switch(test){
			case 0:
				System.out.println("가위");
				break;
				
			case 1:
				System.out.println("바위");
				break;
				
			case 2:
				System.out.println("보");
		}
		
	}

}
