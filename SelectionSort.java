/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * Selection Sort
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class SelectionSort {
    public static void sort(Comparable[] data) {
        ArrayUtil.checkNull(data);
        int m;
        int n = data.length;
        for (int i = 0; i < n; i++) {
            m = i;
            for (int j = i + 1; j < n; j++) {
                if (ArrayUtil.less(data[j], data[m])) {
                    m = j;
                }
            }
            ArrayUtil.exchange(data, m, i);
        }
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
        SelectionSort.sort(a);
        Instant end = Instant.now();
        //ArrayUtil.print(a);

        Duration time = Duration.between(start, end);
        StdOut.println("Execution time: " + time.toNanos() / 1000 + " us.");
    }
}
