package com.company;

import com.company.ADTs.*;
import com.company.Sorting.RadixInt;
import com.company.StdLib.*;

import java.io.IOException;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class Main {

    Random rand = new Random();

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        System.out.println("");

        Integer test[] = randArray(100, 100);
        System.out.println(Arrays.toString(test));
        RadixInt.sort(test);
        System.out.println(Arrays.toString(test));

        System.out.printf("\nTook %1.3fs\n", timer.elapsedTime());
    }

    public static Integer[] randArray(int size, int max) {
        Random rand = new Random();
        Integer result[] = new Integer[size];
        for (int i=0; i<result.length; i++) {
            result[i] = rand.nextInt(max);
        }
        return result;
    }

    // Euclid's algorithm for greatest common denominator
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

}
