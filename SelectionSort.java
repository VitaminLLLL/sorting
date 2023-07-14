/*******************************************************************************
 * Copyright (c) 2023. VitaminL
 * All rights reserved.
 *
 * Selection Sort
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;

public class SelectionSort {
    public static void sort(int[] data) {
        int m;
        int n = data.length;
        for (int i = 0; i < n; i++) {
            m = i;
            for (int j = i + 1; j < n; j++) {
                if (data[m] > data[j]) {
                    m = j;
                }
            }
            int temp = data[i];
            data[i] = data[m];
            data[m] = temp;
        }
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            n = 30;
        } else {
            n = Integer.parseInt(args[0]);
        }
        int[] a = StdRandom.permutation(n);
        ArrayPrint.print(a);
        SelectionSort.sort(a);
        ArrayPrint.print(a);
    }
}
