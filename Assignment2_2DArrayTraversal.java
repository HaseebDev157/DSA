public class Array_2D_Taversal {
    public static void main(String[] args) {
        //Array Traverse
        int[][] arr={{25,34,76},
                     {78,97,12},
                     {23,28,54}};
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
