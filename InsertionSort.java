import java.util.Random;

public class Insertion_Sort {
    static void printarray(int[] arr){
        for (int i = 1; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    // insertion sort time  complexity O(n^2
    static void insertionsort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev= i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
    }

    static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();

        // Generate 1000 random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000) + 1;
        }
        System.out.println("Array Size: " + arr.length);
        System.out.println("Original Array");
        printarray(arr);
        System.out.println();

        // Insertion method calling and time calculation
        long starttime=System.nanoTime();
        insertionsort(arr);
        long endtime=System.nanoTime();
        double  duration=endtime-starttime;

        // sorted array printing
        System.out.println("---sorted array---");
        printarray(arr);
        System.out.println();

        //Time printing
        System.out.println("-----Time taken by Merged Sort for  execution-----");
        System.out.println(duration/1_000_000_000.0+" Seconds");
        System.out.println(duration/1_000_000.0 +" Milliseconds");
        System.out.println(duration+" Nanoseconds");
    }
}
