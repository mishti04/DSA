//                                                  2 way merge sort or binary sort
public class TwoWayMergeSort {
    static int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 88, 81, 4};

    public static void main(String[] args) {
        int chunkSize = 1;
        int arrLastIndex = arr.length - 1;
        while (chunkSize < arrLastIndex) {
            for (int i = 0; i < arrLastIndex; i = i + 2 * chunkSize) {
                //If we dont have enough elements to make a full chunk, send whatever elements we have left as a chunk
                if (i + 2 * chunkSize > arrLastIndex)
                    merge(arr, i, i + chunkSize - 1, arrLastIndex);
                else
                    merge(arr, i, i + chunkSize - 1, i + 2 * chunkSize - 1);
            }
            chunkSize *= 2;
        }
        printArray(arr);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int arrLen = end - start + 1;
        int p = start, q = mid + 1;

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
    private static void printArray(int[] arr) {
        // enhanced for loop
        for (int j : arr)
            System.out.println(j);
    }

}
