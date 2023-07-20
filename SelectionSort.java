/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * Selection Sort
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;

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
        ArrayUtil.print(a);
        SelectionSort.sort(a);
        ArrayUtil.print(a);
    }
}
