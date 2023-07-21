/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * Merge Sort with some optimization
 * 1. Use Insertion sort if array size less than 7
 * 2. Use data as aux then don't need to copy the result.
 * 3. compare data[mid] and data[mid+1] before merge
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.time.Duration;
import java.time.Instant;

public class MergeSort {
    private static final int INSERTION_SORT_SIZE = 7;

    public static void sort(Comparable[] data) {
        ArrayUtil.checkNull(data);
        int hi = data.length - 1;
        int lo = 0;
        Comparable[] aux = data.clone();
        sort(aux, data, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if ((hi - lo) < INSERTION_SORT_SIZE) {
            insertionSort(aux, lo, hi);
            return;
        }
        // Use divide may lead to overflow
        int mid = (hi + lo) >>> 1;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        if (ArrayUtil.less(a[mid], a[mid + 1]))
            System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        merge(a, aux, lo, mid, hi);
        assert ArrayUtil.isSort(aux, lo, hi);
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            for (int j = i; j > lo && ArrayUtil.less(a[j], a[j - 1]); j--)
                ArrayUtil.exchange(a, j - 1, j);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            if (i > mid) aux[k] = a[j++];
            else if (j > hi) aux[k] = a[i++];
            else if (ArrayUtil.less(a[i], a[j])) aux[k] = a[i++];
            else aux[k] = a[j++];
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            n = 30;
        } else {
            n = Integer.parseInt(args[0]);
        }
        Integer[] a = java.util.stream.IntStream.of(StdRandom.permutation(n)).boxed().toArray(Integer[]::new);

        //ArrayUtil.print(a);
        Instant start = Instant.now();
        MergeSort.sort(a);
        Instant end = Instant.now();
        //ArrayUtil.print(a);

        Duration time = Duration.between(start, end);
        StdOut.println("Execution time: " + time.toNanos() / 1000 + " us.");
    }
}
