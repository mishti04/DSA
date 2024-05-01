package SortingAlgorithms;
import java.util.Arrays;

public class CountingSortNegativeInputs {
    static int[] arr = new int[]{8, 3, -5, 1, -3, 8, 6, 4, 3};
    static int[] res;

    public static void main(String[] args) {
        countingSort(arr);
        printArray(res);
    }

    private static void countingSort(int[] arr) {
        //Find the max element
        int max = arr[0], min = arr[0];
        for (int i : arr) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }

        //Create a temp array with counts for respective digits
        int minAbs = Math.abs(min);
        int[] tempArr = new int[minAbs + max +1];
        Arrays.fill(tempArr, 0);
        for (int j : arr)
            tempArr[j+minAbs]++;

        //Create cumulative array
        for (int k = 1; k < tempArr.length; k++)
            tempArr[k] = tempArr[k] + tempArr[k - 1];

        //sort and populate the original array
        res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[tempArr[arr[i] + minAbs] - 1] = arr[i];
            tempArr[arr[i] + minAbs]--;
        }
    }

    private static void printArray(int[] arr) {
        // enhanced for loop
        for (int j : arr)
            System.out.println(j);
    }
}
