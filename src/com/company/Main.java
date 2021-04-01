package com.company;

import java.io.PrintStream;

import java.util.*;

public  class Main {
    private static Scanner in = new Scanner(System.in);
    private static PrintStream out = System.out;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Complex z1 = new Complex(1, 21);
        Complex z2 = new Complex(2, 1.32);
        Complex z3 = z2.neg();

        out.println(z1.toString());
        out.println(z2.toString());
        out.println(z3.toString());

        z1 = z1.parse("1.0 + 2.0i");
        Complex z4 = new Complex().parse("1.0 - 2.1i");
        out.println(z1.toString());
        out.println(z4.toString());
        out.println(z1.abs());
        out.println(z2.abs());
        out.println(z3.conjugate().toString());
        out.println(new Complex().equals(z1, z3));
        out.println(z2.getArgument());
        out.println(z3.eString());
    }
}
