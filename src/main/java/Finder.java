import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.ceil;

/**
 * Created by satheessh on 11/5/16.
 */
public class Finder {

    public static class Value {
        public Value(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public int start;
        public int end;
    }


    public static List<Integer> findMissingNumber(int[] allNumbers, int lastNumber, int bufferSize) {
        if (bufferSize < 4) {
            System.out.println("not enough buffer");
            return null;
        }
        Stack<Value> missingRangeQueue = new Stack<Value>();
        List<Integer> result = new LinkedList<Integer>();

        missingRangeQueue.add(new Value(1, lastNumber));
        long iterationCount = 0;

        while (!missingRangeQueue.isEmpty()) {
            Value value = missingRangeQueue.pop();
            System.out.println("Iterating : " + ++iterationCount + "  " + value);
            int rangeSize = (int) ceil((value.end - value.start + 1.0) / (bufferSize / 2));
            int bucketSize = (int) ceil((value.end - value.start + 1.0) / rangeSize);
            int[] bucket = new int[bucketSize];
            int[] count = new int[bucketSize];
            updateBuckets(allNumbers, value, rangeSize, bucket, count);
            findMissingNumberFromBuckets(missingRangeQueue, result, value, rangeSize,
                    bucketSize, bucket, count);
        }
        return result;
    }

    private static void updateBuckets(int[] allNumbers, Value value, int rangeSize, int[] bucket, int[] count) {
        for (int i = 0; i < allNumbers.length; i++) {
            if (value.start <= allNumbers[i] && value.end >= allNumbers[i]) {
                int bucketIndex = (allNumbers[i] - value.start) / rangeSize;
                bucket[bucketIndex] = bucket[bucketIndex] + allNumbers[i];
                count[bucketIndex]++;
            }
        }
    }

    private static void findMissingNumberFromBuckets(Stack<Value> missingRange, List<Integer> result,
                                                     Value value, int rangeSize, int bucketSize, int[] bucket, int[] count) {
        for (int i = 0; i < bucketSize; i++) {

            int indexStartingNumber = value.start + i * rangeSize;
            int indexEndingNumber;

            /** Hnadles below scenario.
             * Example: range is 1 to 5 and bucket size is 2.
             * The last bucket will have only number 5.
             * **/
            int spillover = (value.end - value.start + 1) % rangeSize;
            if (i == bucketSize - 1 && spillover != 0) {
                indexEndingNumber = indexStartingNumber - 1 + spillover;
            } else {
                indexEndingNumber = indexStartingNumber + rangeSize - 1;
            }

            int rangeSum = indexEndingNumber * (indexEndingNumber + 1) / 2
                    - (indexStartingNumber - 1) * indexStartingNumber / 2;

            if (bucket[i] < rangeSum && count[i] == rangeSize - 1) {
                int missingNumber = rangeSum - bucket[i];
                result.add(missingNumber);
                //System.out.println(missingNumber);
            } else if (rangeSum == bucket[i]) {
                //System.out.println("found all numbers in this range");
            } else {
                missingRange.push(new Value(indexStartingNumber, indexEndingNumber));
            }
        }
    }


    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5, 6, 8, 10, 12, 13, 16};
        System.out.println(findMissingNumber(a, 16, 4));

    }

}
