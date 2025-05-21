package weekend_0517;

//import java.util.Random;

public class MainClass {
	public static void main(String[] arge) {
		


		WeekendList wList = new WeekendList();
		
		
//		for(int i = 0; i<10; i++) {
//			wList.insert(i);
//		}
//		wList.delete(0);
//		wList.delete(5);
//		wList.delete(9);
		
		
		wList.insert(5);
		wList.insert(10);
		wList.insert(15);
		
		wList.insert(10);
		wList.insert(20);
		wList.insert(10);
		wList.insert(25);

		wList.delete(5);
		wList.delete(10);
		wList.delete(15);

		
//		final int MaxSize = 10;
//		Random rand = new Random();
//		
//		for(int i =0; i<MaxSize; i++) {
//			wList.insert(rand.nextInt(MaxSize));
//		}
//		
//		for(int i = 0; i<MaxSize; i++) {
//			wList.delete(rand.nextInt(MaxSize));
//		}
		
		
		

		wList.print();
		

	}

}
