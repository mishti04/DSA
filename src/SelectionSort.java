public class SelectionSort {
    static int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 4, 88};

    public static void main(String[] args) {
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            }
            // we could have added an extra if condition if (minIndex != i)but we are directly swapping.
            //The worst that can happen is , if its not true, it will swap the same number by itself
            // but its such a rare event and does not even cause any problem logically.
            //On the other hand saves us the effort of checking it everytime when its mostly going to be true anyways
            swap(arr, i, minIndex);

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
