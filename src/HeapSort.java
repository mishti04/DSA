public class HeapSort {
    static int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 4, 88};

    public static void main(String[] args) {
        int n = arr.length - 1;
        createHeap(arr, n);
        sortProcess(arr, n);
        printArray(arr);
    }

    private static void sortProcess(int[] arr, int n) {
        for (int i = 0; i <= n; i++) {
            swap(arr, 0, n - i);
            heapify(arr, 0, n - i - 1);
        }
    }

    private static void heapify(int[] arr, int i, int virtualLen) {
        if (i >= virtualLen)
            return;
        int c1Index = i * 2 + 1;
        int c2Index = i * 2 + 2;
        int maxIndex = i;
        if (c1Index <= virtualLen && arr[c1Index] > arr[maxIndex])
            maxIndex = c1Index;
        if (c2Index <= virtualLen && arr[c2Index] > arr[maxIndex])
            maxIndex = c2Index;
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            heapify(arr, maxIndex, virtualLen);
        }

    }
    
    private static void createHeap(int[] arr, int n) {

        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
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
