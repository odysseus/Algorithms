package com.company.StdLib;

import com.company.Sorting.Insertion;
import com.company.Sorting.Selection;

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
//            case "Shell":
//                Shell.sort(a);
//                break;
//            case "Merge":
//                Merge.sort(a);
//                break;
//            case "Quick":
//                Quick.sort(a);
//                break;
//            case "Heap":
//                Heap.sort(a);
//                break;
        }
        return timer.elapsedTime();
    }
}
