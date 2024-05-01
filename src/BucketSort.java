import java.util.*;

public class BucketSort {

    static List<Integer> initialList = Arrays.asList(0, 200, 80, 50, 90, 30, 210, 110, 70, 250, 40, 500, 600, 200, 15);

    public static void main(String[] args) {

        int max = findMax(initialList);
        /* If we want we can reduce the range of each bucket by increasing teh number of buckets
        Here we are using 3 buckets hence the range is 600/3 -> 200
        If we use 4 buckets the range will be 600/4 -> 150
        */
        final int numberOfBuckets = (int) Math.sqrt(initialList.size());
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i : initialList) {
            //          System.out.println(i + "hash - " +hash(i, max, numberOfBuckets));
            buckets.get(hash(i, max, numberOfBuckets)).add(i);
        }

        Comparator<Integer> comparator = Comparator.naturalOrder();

        for (List<Integer> bucket : buckets) {
            bucket.sort(comparator);
        }

        List<Integer> sortedArray = new LinkedList<>();

        for (List<Integer> bucket : buckets) {
            sortedArray.addAll(bucket);
        }

        printArray(sortedArray);
    }

    private static int hash(int i, int max, int numberOfBuckets) {
        return (int) (i / ((max / numberOfBuckets) + 1));
        /* beacuse here we are taking 3 buckets and the max is 600, when divided equally we should get a range of 200 for each bucket
         if we dont add 1, the range will work fine except it will not include the upper bound
         meaning we will get the range 0-199 -> 0 index, 200-399 -> 1 index, 400-599 -> 2 index, 600 -> 3 index(this would be arrayIndexOutOfBound)
         To make the range inclusive of the largest number we have added 1 to the range before dividing
         Now the range is 0-200 -> 0, 201-400 -> 1, 401-600 -> 2
        */
    }


    private static int findMax(List<Integer> input) {
        int m = Integer.MIN_VALUE;
        for (int i : input) {
            m = Math.max(i, m);
        }
        return m;
    }


    private static void printArray(List<Integer> arr) {
        // enhanced for loop
        for (int j : arr)
            System.out.println(j);
    }
}