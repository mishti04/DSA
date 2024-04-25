import java.util.HashMap;
import java.util.Map;

//
//Rather than making a map we can also make a diff class like pair,
// or use an array where 0th elements represnts min and 1st element represents max
public class MaxMinDac {
    static String maxString = "max";
    static String minString = "min";

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 9, 3, 46, 36, 32, 11, 56, 4, 88 };
        Map<String, Integer> res = maxMin(arr);
        System.out.println(res.get(minString));
        System.out.println(res.get(maxString));
    }

    // ModifiedApproach
    /*
     * The idea is to run a single loop, pick values in pairs and keep tracking
     * minimum and maximum.
     * Suppose we have updated the maximum and minimum till (i — 1)th index and
     * stored them in max and min variables.
     * In the next iteration, we consider a pair of values at ith and (i + 1)th
     * indices and try to update max and min till (i + 1)th index.
     * 
     * If X[i] < X[i + 1], then X[i] will be the candidate for minimum, and X[i + 1]
     * will be the candidate for maximum.
     * So we compare X[i] with min and X[i + 1] with max and update both variables.
     */
    private static Map<String, Integer> maxMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int end = arr.length, start = 0;
        if (end % 2 == 1)
            start = 1;

        for (int i = start; i <= end - 1; i = i + 2) {
            int n1 = arr[i], n2 = arr[i + 1];
            if (n1 > n2) {
                if (n1 > max)
                    max = arr[i];
                if (n2 < min)
                    min = arr[i + 1];
            } else {
                if (n2 > max)
                    max = arr[i + 1];
                if (n1 < min)
                    min = arr[i];
            }
        }
        return new HashMap<>(Map.of(minString, min, maxString, max));
    }

    // Approach1
    // private static Map<String, Integer> maxMin(int[] arr, int start, int end) {
    //
    // /*Instantiate a map while declaring it in the same line.
    // Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));
    // */
    //
    // if (start == end)
    // return new HashMap<>(Map.of(minString, arr[start], maxString, arr[end]));
    //
    // else if (start + 1 == end) {
    // if (arr[start] > arr[end])
    // return new HashMap<>(Map.of(minString, arr[end], maxString, arr[start]));
    // else
    // return new HashMap<>(Map.of(minString, arr[start], maxString, arr[end]));
    // } else {
    //
    // int mid = (start + end) / 2;
    // Map<String, Integer> temp1, temp2, result = new HashMap<>();
    // temp1 = maxMin(arr, start, mid);
    // temp2 = maxMin(arr, mid + 1, end);
    // if (temp1.get(minString) < temp2.get(minString))
    // result.put(minString, temp1.get(minString));
    // else
    // result.put(minString, temp2.get(minString));
    //
    // if (temp1.get(maxString) > temp2.get(maxString))
    // result.put(maxString, temp1.get(maxString));
    // else
    // result.put(maxString, temp2.get(maxString));
    // return result;
    // }
    // }
}
