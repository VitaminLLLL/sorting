/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * int array manipulations
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;

public class ArrayUtil {
    public static void print(Object[] a) {
        if (a == null) throw new IllegalArgumentException("");
        StdOut.print("[");
        for (Object i : a) {
            StdOut.print(i + " ");
        }
        StdOut.print("]\n");
    }

    public static void exchange(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
