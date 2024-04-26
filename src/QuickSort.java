public class QuickSort {
    static int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 4, 88};

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start == end)
            return;
        else if (start + 1 == end) {
            if (arr[start] > arr[end])
                swap(arr, start, end);
            return;
        }
        int m = partitian(arr, start, end);
        quickSort(arr, start, m);
        quickSort(arr, m + 1, end);
    }

    private static int partitian(int[] arr, int start, int end) {
        int p = arr[start];
        //j keeps track of how many elements we have encountered that are smaller than pivot
        //k takes care of iterating though all the elements in the array
        int i = start, j = i;
        for (int k = i + 1; k < end; k++) {
            if (arr[k] < p) {
                j++;
                swap(arr, k, j);

            }
        }
        swap(arr, start,j);
        return j;
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
