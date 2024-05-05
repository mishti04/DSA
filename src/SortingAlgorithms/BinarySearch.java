package SortingAlgorithms;

public class BinarySearch {

    static int[] arr = new int[]{2, 6, 8, 11, 12, 22, 35, 65};

    public static void main(String[] args) {

        System.out.println(BS(arr, 0, arr.length - 1, 20));
    }

    private static int BS(int[] arr, int i, int j, int k) {
        if (i > j)
            return -1;
        int m = (i + j) / 2;
        if (arr[m] == k)
            return m;
        else if (arr[m] > k)
            return BS(arr, i, m - 1, k);
        else
            return BS(arr, m + 1, j, k);

    }
}
