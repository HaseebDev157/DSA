import java.util.Arrays;

public class Array_2D_Reverse {
    public static void main(String[] args) {
        int[][] arr={{25,34,76},
                {78,97,12},
                {23,28,54}};
        System.out.println("Array Before Reverse:");
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<arr.length;i++) {
            int start=0;
            int end=arr.length-1;
            while (start < end) {
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }
        }
        System.out.println("Reversed Array.");
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
