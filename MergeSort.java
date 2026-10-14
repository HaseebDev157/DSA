import java.util.Random;
public class Merge_Sort {
    static int[] arr;
   static void printarray(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int [] temp=new int [end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //copy remaining into temp
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        //copy the temp array into original array
        for(int x=0;x<temp.length;x++){
            arr[start+x]=temp[x];
        }
    }
    static void merge_sort(int start, int end) {
        if(start<end){
            int mid =start+(end-start)/ 2;
            merge_sort(start,mid);
            merge_sort(mid+1,end);
            merge(start,mid,end);
        }
    }
    public static void main(String[] args) {
         arr = new int[1000];
        Random rand = new Random();

        // Generate 1000 random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000) + 1;
        }
        System.out.println("Array Size: "+arr.length);
        System.out.println("Original array");
        printarray(arr);

        //function call
        long starttime=System.nanoTime();
        merge_sort(0,arr.length-1);
        long endtime=System.nanoTime();
        double duration=endtime-starttime;

        System.out.println();
        System.out.println("---sorted array---");
        printarray(arr);
        System.out.println();

        System.out.println("-----Time taken by Merged Sort for  execution-----");
        System.out.println(duration/1_000_000_000.0+" Seconds");
        System.out.println(duration/1_000_000.0 +" Milliseconds");
        System.out.println(duration+" Nanoseconds");
    }
}
