/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * Merge Sort with some optimization
 * 1. Use Insertion sort if array size less than 7
 * 2. forget..
 ******************************************************************************/

public class MergeSort {
    private static final int INSERTION_SORT_SIZE = 7;

    public static void sort(Comparable[] data) {
        ArrayUtil.checkNull(data);
        int n = data.length;
        int hi = n - 1;
        int lo = 0;
        Comparable[] aux = new Comparable[n];
        System.arraycopy(data, 0, aux, 0, n);
        sort(data, aux, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if ((hi - lo) < INSERTION_SORT_SIZE) {
            insertionSort(a, lo, hi);
            return;
        }
        int mid = (hi + lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
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
        System.arraycopy(aux, lo, a, lo, hi - lo + 1);
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            n = 30;
        } else {
            n = Integer.parseInt(args[0]);
        }
        Integer[] a = java.util.stream.IntStream.of(edu.princeton.cs.algs4.StdRandom.permutation(n)).boxed().toArray(Integer[]::new);

        ArrayUtil.print(a);
        MergeSort.sort(a);
        ArrayUtil.print(a);
    }
}
