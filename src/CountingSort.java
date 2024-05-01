import java.util.Arrays;

public class CountingSort {
    static int[] arr = new int[]{8, 3, 5, 1, 3, 8, 6, 4, 3};
    static int[] res;

    public static void main(String[] args) {
        countingSort(arr);
        printArray(res);
    }

    private static void countingSort(int[] arr) {
        //Find the max element
        int max = arr[0];
        for (int i : arr)
            if (i > max)
                max = i;

        //Create a temp array with counts for respective digits
        int[] tempArr = new int[max + 1];
        Arrays.fill(tempArr, 0);
        for (int j : arr)
            tempArr[j]++;

        //Create cumulative array
        for (int k = 1; k < tempArr.length; k++)
            tempArr[k] = tempArr[k] + tempArr[k - 1];

        //sort and populate the original array
        res = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            res[tempArr[arr[i]] - 1] = arr[i];
            tempArr[arr[i]]--;
        }
    }

    private static void printArray(int[] arr) {
        // enhanced for loop
        for (int j : arr)
            System.out.println(j);
    }
}
