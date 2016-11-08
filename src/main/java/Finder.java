import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<Value> missingRangeQueue = new LinkedList<Value>();
        List<Integer> result = new LinkedList<Integer>();

        missingRangeQueue.add(new Value(1, lastNumber));
        long iterationCount = 0;

        while (!missingRangeQueue.isEmpty()) {
            Value value = missingRangeQueue.poll();
            System.out.println("Iterating : " + iterationCount + "  " + value);

            int range = (int) ceil((value.end - value.start + 1.0) / (bufferSize / 2));
            int bucketSize = (int) ceil((value.end - value.start + 1.0) / range);
            int[] bucket = new int[bucketSize];
            int[] count = new int[bucketSize];
            updateBuckets(allNumbers, value, range, bucket, count);
            findMissingNumberFromBuckets(missingRangeQueue, result, value, range,
                    bucketSize, bucket, count);
        }
        return result;
    }

    private static void updateBuckets(int[] allNumbers, Value value, int range, int[] bucket, int[] count) {
        for (int i = 0; i < allNumbers.length; i++) {
            if (value.start <= allNumbers[i] && value.end >= allNumbers[i]) {
                int bucketIndex = (allNumbers[i] - value.start) / range;
                bucket[bucketIndex] = bucket[bucketIndex] + allNumbers[i];
                count[bucketIndex]++;
            }
        }
    }

    private static void findMissingNumberFromBuckets(Queue<Value> missingRange, List<Integer> result,
                                                     Value value, int range, int bucketSize, int[] bucket, int[] count) {
        for (int i = 0; i < bucketSize; i++) {

            int indexStartingNumber = value.start + i * range;
            int indexEndingNumber;
            int spillover = (value.end - value.start + 1) % range;
            if (i == bucketSize - 1 && spillover != 0) {
                indexEndingNumber = indexStartingNumber - 1 + spillover;
            } else {
                indexEndingNumber = indexStartingNumber + range - 1;
            }

            int rangeSum = indexEndingNumber * (indexEndingNumber + 1) / 2
                    - (indexStartingNumber - 1) * indexStartingNumber / 2;

            if (bucket[i] < rangeSum && count[i] == range - 1) {
                int missingNumber = rangeSum - bucket[i];
                result.add(missingNumber);
                //System.out.println(missingNumber);
            } else if (rangeSum == bucket[i]) {
                //System.out.println("found all numbers in this range");
            } else {
                missingRange.offer(new Value(indexStartingNumber, indexEndingNumber));
            }
        }
    }


    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5, 6, 8, 10, 12, 13, 16};
        findMissingNumber(a, 16, 4);

    }

}
