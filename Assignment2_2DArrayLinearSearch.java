import java.util.Scanner;

import java.util.Scanner;
public class Array_2D_LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number to Search:");
        int n = sc.nextInt();
        int[][] arr={{25,34,76},
                {78,97,12},
                {23,28,54}};
        boolean found=false;
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (n == arr[i][j]) {
                    found = true;
                    System.out.println(arr[i][j] + " found at Row number " + i + " and Column number " + j);
                    break;
                }
            }
        }
            if(!found){
                System.out.println("Number Not Found!");
            }
        }
    }

