package sec03.exam03;

public class ByteOperationExamlpe {

	public static void main(String[] args) {
		
		byte result1 = 10 + 20;
		System.out.println("result1 : " + result1);
		System.out.println("result1의 타입: " + ((Object) result1).getClass().getSimpleName());

		
		byte x = 10;
		byte y = 20;
		int result2 = x + y;
		System.out.println("result2 : " + result2);
		System.out.println("result2의 타입: " + ((Object) result2).getClass().getSimpleName());

	}

}
