import java.util.Arrays;

public class BubbleSort {
    static int[] arr = new int[]{5, 1, 2, 3, 4, 6, 7, 8, 9};
    //In this array only one element is out of place that too the first element.
    //So it should stop running after the outer loop finishes 1 iteration

    public static void main(String[] args) {
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean anySwaps = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    anySwaps = true;
                }
            }
            if (!anySwaps)
                break;
        }
    }

    private static void printArray(int[] arr) {
        // enhanced for loop
        for (int j : arr)
            System.out.println(j);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
