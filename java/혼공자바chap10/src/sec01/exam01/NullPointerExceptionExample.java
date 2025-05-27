package sec01.exam01;

@SuppressWarnings("null") // 널포인트 경고 무시


public class NullPointerExceptionExample {
	public static void main(String[] args) {
		String data = null;
		System.out.println(data.toString()); // NullPointer Exception 발생
	}

}
