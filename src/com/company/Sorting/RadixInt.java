package com.company.Sorting;

public class RadixInt {

    public static void sort(Integer[] a) {
        String[] sa = new String[a.length];
        int max = 0;
        for (int i=0; i<a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int maxlen = Integer.toString(max).length();

        for (int i=0; i<a.length; i++) {
            sa[i] = a[i].toString();
        }

        int place = 0;
        while (place < maxlen) {
        }
    }

    // Finds the integer value at the given place value starting from the end.
    // 0 indexed
    public static int reverseIntAt(String s, int i) {
        if (Math.abs(i) < s.length()) {
            return s.charAt(s.length() - (i + 1)) - 48;
        } else {
            return 0;
        }
    }

}
