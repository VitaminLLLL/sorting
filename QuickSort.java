/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * QuickSort, Use Insertion Sort as well for short array.
 * Add implementation when there are multi duplicates.
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.time.Duration;
import java.time.Instant;

public class QuickSort {
    public static final int INSERTION_SORT_SIZE = 7;

    public static void sort(Comparable[] data) {
        ArrayUtil.checkNull(data);
        //StdRandom.shuffle(data);
        int lo = 0;
        int hi = data.length - 1;
        sort(data, lo, hi);
        assert ArrayUtil.isSort(data, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return; //add check;
        if ((hi - lo) < INSERTION_SORT_SIZE) {
            insertionSort(a, lo, hi);
            return;
        }
        int k = partition(a, lo, hi);
        sort(a, lo, k - 1);
        sort(a, k + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            if (ArrayUtil.less(a[i], a[lo])) i++;
            else if (ArrayUtil.less(a[lo], a[j])) j--;
            else ArrayUtil.exchange(a, i++, j);
        }
        ArrayUtil.exchange(a, lo, i - 1);
        return i - 1;
    }

    // Sorting with 3 way partition(many duplicates)
    private static void sortThreeWay(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo + 1;
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            if (ArrayUtil.less(a[i], v))
                ArrayUtil.exchange(a, i++, lt++);
            else if (ArrayUtil.less(v, a[i]))
                ArrayUtil.exchange(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            for (int j = i; j > lo && ArrayUtil.less(a[j], a[j - 1]); j--)
                ArrayUtil.exchange(a, j, j - 1);
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            n = 30;
        } else {
            n = Integer.parseInt(args[0]);
        }
        Integer[] a = java.util.stream.IntStream.of(StdRandom.permutation(n)).boxed().toArray(Integer[]::new);
        //String[] b = new String[]{"B", "B", "B", "G", "R", "Q", "R", "R", "G", "S", "B", "B", "G", "G", "G", "R"};
        //String[] b = new String[]{"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        //ArrayUtil.print(a);
        Instant start = Instant.now();
        QuickSort.sort(a);
        //QuickSort.sortThreeWay(b, 0, b.length - 1);
        Instant end = Instant.now();
        //ArrayUtil.print(a);

        Duration time = Duration.between(start, end);
        StdOut.println("Execution time: " + time.toNanos() / 1000 + " us.");
    }
}
