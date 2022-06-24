import java.util.ArrayList;
import java.util.Random;

/*INSTRUCTIONS
the only thing needed is to run program. To see differences in times you can alter
the arrSize in the main method for the size of the randomized array.
At arrSize = 200 merge sort is faster
At arrSize = 10 insertion sort is faster
At arrSize = 15 many values overlap where merge = insertion

Question 3:
    a) The invariant will hold given to the conditions. After iteration i
       is completed, the elements on the right will be sorted. Conditions
       cause loop to be true before iteration starts and continues to be
       true until termination.

    b) O(n^2) is worst-case for bubble sort. Both are O(n^2). Insertion sort
       uses 1 assignment variable where a bubble sort uses 3 for swapping.
*/

public class Sorts {

    public static int insertion_sort(int[] arr) {
        long start = System.nanoTime();

        for (int x = 1; x < arr.length; x++) {
            int arrInt = arr[x];
            int i = x - 1;

            while(i >= 0 && arr[i] > arrInt) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = arrInt;

        }

        long end = System.nanoTime();
        long methodTime = ((end - start));

//        System.out.println("\n\nInsertion Sorted Array");
//        for (int x = 0; x < arr.length; x++) {
//            System.out.print(arr[x] + " ");
//        }
//
//        System.out.println("\ntime for sort: " + methodTime + " nanoseconds");
        return (int)methodTime;
    }

    public static int merge_sort(int[] arr) {
        int mid = arr.length / 2;
        int leftArr[] = new int[mid];
        int rightArr[] = new int[mid - (arr.length / 2)];

        long start = System.nanoTime();

        for (int x = 0; x < leftArr.length; x++) {
            leftArr[x] = arr[x];
        }
        for (int x = 0;x < rightArr.length; x++) {
            rightArr[x - mid] = arr[x];
        }

        long end = System.nanoTime();
        long methodTime = ((end - start));
//        System.out.println("\nmerge Sorted Array");
//        for (int x = 0; x < arr.length; x++) {
//            System.out.print(arr[x] + " ");
//        }
//        System.out.println("\ntime for sort: " + methodTime + " nanoseconds");
        return (int)methodTime;
    }

    public static void merge(int arr[], int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            merge(arr, low, mid);
            merge(arr, mid + 1, high);

            merge_sort(arr);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> x_values = new ArrayList<>();
        ArrayList<Integer> y_merge = new ArrayList<>();
        ArrayList<Integer> y_insert = new ArrayList<>();
        Random rand = new Random();                 //random for random int population

        int arrSize = 100;                           //array size
        System.out.print("size of array: " + arrSize);
        int arr[] = new int[arrSize];               //set array to input size
        System.out.println("\nArray Values");
        for (int x = 0; x < arr.length; x++) {      //populate array with random ints 0 - 100
            arr[x] = rand.nextInt(100);
            System.out.print(arr[x] + " ");

        }
        for(int i = 1; i < arrSize; i += (arrSize / 10)) {
            x_values.add(i);
            y_merge.add(merge_sort(arr));
            y_insert.add(insertion_sort(arr));

        }
        insertion_sort(arr);
        merge_sort(arr);
        System.out.println("\n\nx values: " + x_values);
        System.out.println("insert y's:" + y_insert);
        System.out.println("merge y's:" + y_merge);

    }
}

