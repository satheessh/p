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

        public int start;
        public int end;
    }


    public static List<Integer> findMissingNumber(int[] allNumbers, int lastNumber, int bufferSize) {
        Queue<Value> missingRange = new LinkedList<Value>();
        List<Integer> result = new LinkedList<Integer>();

        missingRange.add(new Value(1, lastNumber));

        while (!missingRange.isEmpty()) {
            System.out.println("Will iterate the input array. ");
            Value value = missingRange.poll();

            int range = (int) ceil((value.end - value.start + 1.0) / (bufferSize / 2));
            int bucketSize = (int) ceil((value.end - value.start + 1.0) / range);

            int[] bucket = new int[bucketSize];
            int[] count = new int[bucketSize];


            for (int i = 0; i < allNumbers.length; i++) {
                if (value.start <= allNumbers[i] && value.end >= allNumbers[i]) {
                    int bucketIndex = (allNumbers[i] - value.start) / range;
                    bucket[bucketIndex] = bucket[bucketIndex] + allNumbers[i];
                    count[bucketIndex]++;
                }
            }


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
                    System.out.println(missingNumber);
                } else if (rangeSum == bucket[i]) {
                    System.out.println("found all numbers in this range");
                } else {
                    missingRange.add(new Value(indexStartingNumber, indexEndingNumber));
                }
            }
        }
        return result;
    }


    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5, 6, 8, 10, 12, 13, 16};
        findMissingNumber(a, 16, 4);

    }

}
