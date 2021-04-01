package com.company;

import java.io.PrintStream;

import java.util.*;

public  class Main {
    private static Scanner in = new Scanner(System.in);
    private static PrintStream out = System.out;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        HashMap<Complex, Complex> map = new HashMap<>();
        map.put(new Complex(), new Complex(1, 0));
        map.put(new Complex(), new Complex(1, 0));
        map.put(new Complex(1, 0), new Complex(1, 0));
        map.put(new Complex(), new Complex(1, 0));
        System.out.println(map.containsKey(new Complex(1, 0)));
    }
}
