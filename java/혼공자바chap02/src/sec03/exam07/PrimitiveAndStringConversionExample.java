package sec03.exam07;

public class PrimitiveAndStringConversionExample {

	public static void main(String[] args) {

		
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1 : " + value1);
		System.out.println("value2 : " + value2);
		System.out.println("value3 : " + value3);
		
		System.out.println("value1의 타입: " + ((Object) value1).getClass().getSimpleName());
		System.out.println("value2의 타입: " + ((Object) value2).getClass().getSimpleName());
		System.out.println("value3의 타입: " + ((Object) value3).getClass().getSimpleName());


		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		System.out.println("str1의 타입: " + ((Object) str1).getClass().getSimpleName());
		System.out.println("str2의 타입: " + ((Object) str2).getClass().getSimpleName());
		System.out.println("str3의 타입: " + ((Object) str3).getClass().getSimpleName());

	}

}
