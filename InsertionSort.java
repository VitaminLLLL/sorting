/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * InsertionSort
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class InsertionSort {
    public static void sort(Comparable[] data) {
        ArrayUtil.checkNull(data);
        int n = data.length;
        for (int i = 1; i < n; i++)
            for (int j = i; j > 0 && ArrayUtil.less(data[j], data[j - 1]); j--)
                ArrayUtil.exchange(data, j, j - 1);
        assert ArrayUtil.isSort(data, 0, n - 1);
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            n = 30;
        } else {
            n = Integer.parseInt(args[0]);
        }
        Integer[] a = IntStream.of(StdRandom.permutation(n)).boxed().toArray(Integer[]::new);

        //ArrayUtil.print(a);
        Instant start = Instant.now();
        InsertionSort.sort(a);
        Instant end = Instant.now();
        //ArrayUtil.print(a);

        Duration time = Duration.between(start, end);
        StdOut.println("Execution time: " + time.toNanos() / 1000 + " us.");
    }
}
