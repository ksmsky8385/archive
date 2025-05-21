package mini_project_04_배열;

public class No5_Main {
    public static void main(String[] args) {
        int[] a = {69, 10, 30, 2, 16, 8, 31, 22};

        System.out.print("Input Data : ");
        for (int i = 0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");


        for (int j = 0; j < a.length-1; j++) {
            No5_Sort.sort(a, j);
            No5_Sort_Bubble.sort_bubble(a, j);
            
        }
    }
}
