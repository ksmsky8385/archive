package mini_project_04_배열;

public class No5_1 {

	public static void main(String[] args) {
		
		int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
		
		System.out.println("Input Data : 69 10 30 2 16 8 31 22\n");
		
    	int m0 = 0;

        for (int i = 0; i < 8; i++) {
            if (a[i] < a[m0]) {
                m0 = i;
            }
        }
        int n0 = a[0];
        a[0] = a[m0];
        a[m0] = n0;
        
        System.out.println("Sorted Data 1단계 : " + a[0] + " " +a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
        
    	int m1 = 1;

        for (int i = 1; i < 8; i++) {
            if (a[i] < a[m1]) {
                m1 = i;
            }
        }
        int n1 = a[1];
        a[1] = a[m1];
        a[m1] = n1;
        
        System.out.println("Sorted Data 2단계 : " + a[0] + " " +a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
        
        int m2 = 2;

        for (int i = 2; i < 8; i++) {
            if (a[i] < a[m2]) {
                m2 = i;
            }
        }
        int n2 = a[2];
        a[2] = a[m2];
        a[m2] = n2;
        
        System.out.println("Sorted Data 3단계 : " + a[0] + " " +a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
        
        int m3 = 3;

        for (int i = 3; i < 8; i++) {
            if (a[i] < a[m3]) {
                m3 = i;
            }
        }
        int n3 = a[3];
        a[3] = a[m3];
        a[m3] = n3;
        
        System.out.println("Sorted Data 4단계 : " + a[0] + " " +a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
        
        int m4 = 4;

        for (int i = 4; i < 8; i++) {
            if (a[i] < a[m4]) {
                m4 = i;
            }
        }
        int n4 = a[4];
        a[4] = a[m4];
        a[m4] = n4;
        
        System.out.println("Sorted Data 5단계 : " + a[0] + " " +a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
        
        int m5 = 5;

        for (int i = 5; i < 8; i++) {
            if (a[i] < a[m5]) {
                m5 = i;
            }
        }
        int n5 = a[5];
        a[5] = a[m5];
        a[m5] = n5;
        
        System.out.println("Sorted Data 6단계 : " + a[0] + " " +a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
        
        int m6 = 6;

        for (int i = 6; i < 6; i++) {
            if (a[i] < a[m6]) {
                m6 = i;
            }
        }
        int n6 = a[6];
        a[6] = a[m6];
        a[m6] = n6;
        
        System.out.println("Sorted Data 7단계 : " + a[0] + " " +a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
        
	}

}
