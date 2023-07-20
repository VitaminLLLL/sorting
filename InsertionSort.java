/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * InsertionSort
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

public class InsertionSort {
    public static void sort(Comparable[] data) {
        ArrayUtil.checkNull(data);
        int n = data.length;
        for (int i = 1; i < n; i++)
            for (int j = i; j > 0 && ArrayUtil.less(data[j], data[j - 1]); j--)
                ArrayUtil.exchange(data, j, j - 1);
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
        InsertionSort.sort(a);
        ArrayUtil.print(a);
    }
}
