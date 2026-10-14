import java.util.Random;
public class Bubble_sort {
    static void printarray(int[] arr){
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
    }
    static void bubblesort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    static void main(String[] args) {

        int[] arr = new int[1000];
        Random rand = new Random();

        // Generate 1000 random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000) + 1;
        }
    System.out.println("Array Size: "+arr.length);
    printarray(arr);
    System.out.println("sorted array");
    long starttime=System.nanoTime();
    bubblesort(arr);
    long endtime=System.nanoTime();
    double duration=endtime-starttime;
    printarray(arr);

        System.out.println("-----Time taken by Bubble sort for  execution-----");
        System.out.println(duration/1_000_000_000.0+" Seconds");
        System.out.println(duration/1_000_000.0 +" Milliseconds");
        System.out.println(duration+" Nanoseconds");
    }
}
