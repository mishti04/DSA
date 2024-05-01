package SortingAlgorithms;
public class MergeSort {
    static int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 4, 88};

    public static void main(String[] args) {
//Technically in both the merge sort examples, the function mergeSort is only responsible to decide in what way we want to split the array.
// The actual sorting is technically done by the merge function.
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start == end)
            return;
        else if (start + 1 == end) {
            if (arr[start] > arr[end])
                swap(arr, start, end);
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
        return;

    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int p = start, q = mid + 1;
        int arrLen = end - start + 1;
        int[] tempArr = new int[arrLen];
        int k = 0;
        for (int i = start; i <= end; i++) {
            // check if 1st part came to an end or not
            if (q > end)
                tempArr[k++] = arr[p++];

                // check if 2nd part came to an end or not
            else if (p > mid)
                tempArr[k++] = arr[q++];

                // If both have not come to an end, check which is smaller
            else if (arr[p] < arr[q])
                tempArr[k++] = arr[p++];
            else
                tempArr[k++] = arr[q++];

        }

        // Move temp array data to original array for further sorting
        for (int t = 0, j = start; j <= end; j++, t++) {
            arr[j] = tempArr[t];
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        // enhanced for loop
        for (int j : arr)
            System.out.println(j);
    }

}
