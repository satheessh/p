import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

/**
 * Created by satheessh on 11/8/16.
 */
public class FinderTest {

    @Test
    public void findMissingNumberTest() {

        int[] i1 = {1, 2, 3, 4, 5, 6, 8, 10, 12, 13, 16};
        List<Integer> actual = Finder.findMissingNumber(i1, 16, 4);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15), actual);


    }

    @Test
    public void findMissingNumberTest2() {
        int[] i2 = {1, 2, 3, 4, 5, 6, 8, 10, 12, 13, 16};
        List<Integer> actual = Finder.findMissingNumber(i2, 16, 8);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15), actual);
    }


    @Test
    public void findMissingNumberTest3() {
        int[] a = {1, 2, 3, 13, 16, 4, 5, 6, 8, 10, 12};
        List<Integer> actual = Finder.findMissingNumber(a, 16, 8);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15), actual);
    }


    @Test
    public void findMissingNumberTest4() {
        int[] a = {1, 2, 3, 13, 16, 4, 5, 6, 8, 10, 12};
        List<Integer> actual = Finder.findMissingNumber(a, 16, 8);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15), actual);
    }

    @Test
    public void findMissingNumberTest5() {
        int[] a = {1, 2, 3, 13, 16, 4, 5, 6, 8, 10, 12};
        List<Integer> actual = Finder.findMissingNumber(a, 16, 16);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15), actual);
    }

    @Test
    public void findMissingNumberTest6() {
        int[] a = {1, 2, 3, 13, 16, 4, 5, 6, 8, 10, 12};
        List<Integer> actual = Finder.findMissingNumber(a, 16, 32);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15), actual);
    }


    @Test
    public void findMissingNumberTest7() {
        int[] a = {1, 2, 3, 13, 4, 5, 6, 8, 10, 12};
        List<Integer> actual = Finder.findMissingNumber(a, 16, 7);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15, 16), actual);
    }


    @Test
    public void findMissingNumberTest8() {
        int[] a = {1, 2, 3, 4, 5, 6, 8, 10, 12, 13};
        List<Integer> actual = Finder.findMissingNumber(a, 18, 6);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15, 16, 17, 18), actual);
    }

    @Test
    public void findMissingNumberTest9() {
        int[] a = {1, 2, 3, 4, 5, 6, 8, 10, 12, 13};
        List<Integer> actual = Finder.findMissingNumber(a, 18, 9);
        sort(actual);
        assertEquals(asList(7, 9, 11, 14, 15, 16, 17, 18), actual);
    }

    @Test
    public void findMissingNumberTest10() {
        int[] a = {};
        List<Integer> actual = Finder.findMissingNumber(a, 18, 9);
        sort(actual);
        assertEquals(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18), actual);
    }


    @Test
    public void findMissingNumberTest11() {
        List<Integer> removedList = new LinkedList<Integer>();
        removedList.add(100);
        removedList.add(101);
        removedList.add(102);
        removedList.add(103);
        int lastNumber = 8192;
        int a[] = new int[lastNumber - removedList.size()];
        for (int i = 1, index = 0; i <= lastNumber; i++) {
            if (!removedList.contains(i)) {
                a[index] = i;
                index++;
            }
        }
        List<Integer> actual = Finder.findMissingNumber(a, lastNumber, 16);
        sort(actual);
        assertEquals(removedList, actual);
    }


}
