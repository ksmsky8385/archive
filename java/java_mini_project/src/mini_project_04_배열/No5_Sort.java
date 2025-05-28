package mini_project_04_배열;

public class No5_Sort {
    public static void sort(int[] a, int j) {
    	
        int b = j;

        for (int i = j + 1; i < a.length; i++) {
            if (a[i] < a[b]) {
                b = i;
            }
        }

        int temp = a[j];
        a[j] = a[b];
        a[b] = temp;

        System.out.print("Sorted Data " + (j + 1) + "단계 : ");
        for(int i = 0; i<a.length; i++) {
        	System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}