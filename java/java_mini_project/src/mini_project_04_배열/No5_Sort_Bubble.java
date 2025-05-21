package mini_project_04_배열;

public class No5_Sort_Bubble {
    public static void sort_bubble(int[] a, int j) {

        System.out.println("Bubble Sorted Data " + (j + 1) + "단계 : ");

        for (int i = 1; i < a.length-j; i++) {
            if (a[i-1] > a[i]) {
                int temp = a[i-1];
                a[i-1] = a[i];
                a[i] = temp;
            }
        
        for(int k = 0; k<a.length; k++) {
             System.out.print(a[k] + " ");
            }
        System.out.println();

        }

        System.out.println();

	}

}
