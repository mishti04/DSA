package SortingAlgorithms;

import java.util.HashMap;
import java.util.Map;


//
//Rather than making a map we can also make a diff class like pair,
// or use an array where 0th elements represnts min and 1st element represents max
public class MaxMinDACBasicApproach {
    static String maxString = "max";
    static String minString = "min";

    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 4, 88};
        Map<String, Integer> res = maxMin(arr, 0, arr.length - 1);
        System.out.println(res.get(minString));
        System.out.println(res.get(maxString));
    }

    private static Map<String, Integer> maxMin(int[] arr, int start, int end) {

     /*Instantiate a map while declaring it in the same line.
     Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));
     */

        if (start == end)
            return new HashMap<>(Map.of(minString, arr[start], maxString, arr[end]));

        else if (start + 1 == end) {
            if (arr[start] > arr[end])
                return new HashMap<>(Map.of(minString, arr[end], maxString, arr[start]));
            else
                return new HashMap<>(Map.of(minString, arr[start], maxString, arr[end]));
        } else {

            int mid = (start + end) / 2;
            Map<String, Integer> temp1, temp2, result = new HashMap<>();
            temp1 = maxMin(arr, start, mid);
            temp2 = maxMin(arr, mid + 1, end);
            if (temp1.get(minString) < temp2.get(minString))
                result.put(minString, temp1.get(minString));
            else
                result.put(minString, temp2.get(minString));

            if (temp1.get(maxString) > temp2.get(maxString))
                result.put(maxString, temp1.get(maxString));
            else
                result.put(maxString, temp2.get(maxString));
            return result;
        }
    }
}
