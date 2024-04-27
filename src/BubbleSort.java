import java.util.Arrays;

public class BubbleSort {
    static int[] arr = new int[]{5, 9, 3, 46, 36, 32, 11, 56, 4, 88};

    public static void main(String[] args) {
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr){
        for(int i =0; i<arr.length; i++){
            int[] tempArr = Arrays.copyOf(arr,arr.length);
            boolean sameIteration = false;
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]>arr[j])
                    swap(arr, i, j);
            }
            for(int k =0; k<arr.length;k++){

                if(arr[k]!=tempArr[k]) {
                    sameIteration=true;
                    break;
                }
            }
            if(sameIteration)
                break;
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
