/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 * <p>
 * Array print helper
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;

public class ArrayPrint {
    public static void print(int[] a) {
        StdOut.print("[");
        for (int i : a) {
            StdOut.print(i + " ");
        }
        StdOut.print("]\n");
    }
}
