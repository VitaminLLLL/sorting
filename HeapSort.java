import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * HeapSort Implementation
 ******************************************************************************/

public class HeapSort {

    public static void sort(Comparable[] data) {
        ArrayUtil.checkNull(data);
        heapify(data);
        //Sort as delMax
        int n = data.length;
        while (n > 1) {
            ArrayUtil.exchange(data, n - 1, 0);
            sink(data, 1, --n);
        }
        assert ArrayUtil.isSort(data, 0, n - 1);
    }

    // Build a maximum heap tree
    private static void heapify(Comparable[] a) {
        int n = a.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(a, i, n);
        }
    }

    // Simplify the implementation!
    private static void sink(Comparable[] a, int i, int n) {
        int k = i;
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && ArrayUtil.less(a[j - 1], a[j])) j++;
            if (!ArrayUtil.less(a[k - 1], a[j - 1])) break;
            ArrayUtil.exchange(a, k - 1, j - 1);
            k = j;
        }
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            n = 10;
        } else {
            n = Integer.parseInt(args[0]);
        }
        Integer[] a = IntStream.of(StdRandom.permutation(n)).boxed().toArray(Integer[]::new);
        //Integer[] a = new Integer[]{5, 8, 14, 4, 7, 2, 3, 6, 12, 10, 0, 11, 13, 9, 1};

        Instant start = Instant.now();
        HeapSort.sort(a);
        Instant end = Instant.now();
        //ArrayUtil.print(a);

        Duration time = Duration.between(start, end);
        StdOut.println("Execution time: " + time.toNanos() / 1000 + " us.");
    }
}
