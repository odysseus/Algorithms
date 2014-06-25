package com.company.StdLib;

import com.company.Sorting.Insertion;
import com.company.Sorting.Selection;
import com.company.Sorting.Shell;
import com.company.Sorting.Merge;

public class SortCompare {

    public static double time(String algo, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        switch (algo) {
            case "Insertion":
                Insertion.sort(a);
                break;
            case "Selection":
                Selection.sort(a);
                break;
            case "Shell":
                Shell.sort(a);
                break;
            case "Merge":
                Merge.sort(a);
                break;
//            case "Quick":
//                Quick.sort(a);
//                break;
//            case "Heap":
//                Heap.sort(a);
//                break;
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t=0; t < T; t++) {
            for (int i=0; i<N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static String compare(String alg1, String alg2, int N, int T) {
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        String faster, slower;
        double ratio;
        if (t1 < t2) {
            ratio = t2 / t1;
            faster = alg1;
            slower = alg2;
        } else {
            ratio = t1 / t2;
            faster = alg2;
            slower = alg1;
        }
        String result = "For " + N + " random doubles\n" + faster + " is " +
                String.format("%3.3f", ratio) + " times faster than " + slower;
        return result;
    }
}
