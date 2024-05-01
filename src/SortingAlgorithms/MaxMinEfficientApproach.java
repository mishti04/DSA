package SortingAlgorithms;

import java.util.HashMap;
import java.util.Map;

//                                      Efficient approach: Incrementing loop by 2, basically an iterative approach
//
//Rather than making a map we can also make a diff class like pair,
// or use an array where 0th elements represnts min and 1st element represents max
public class MaxMinEfficientApproach {
    static String maxString = "max";
    static String minString = "min";

    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 4, 88};
        Map<String, Integer> res = maxMin(arr);
        System.out.println(res.get(minString));
        System.out.println(res.get(maxString));
    }

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

}
