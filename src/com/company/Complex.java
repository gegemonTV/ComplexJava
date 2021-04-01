package com.company;

import java.util.Locale;
import java.util.Objects;

public class Complex {

    private double real, imag;

//--------------------------------------пункт 1-----------------------------------------
    public Complex() {
        this.real = 0;
        this.imag = 0;
    }

    public Complex(double real, double imag) {
        this.imag = imag;
        this.real = real;
    }

    public Complex(Complex c) {
        this.imag = c.getImaginary();
        this.real = c.getReal();
    }

    public double getReal(){
        return this.real;
    }

    public double getImaginary() {
        return this.imag;
    }
//------------------------------------пункт 2---------------------------------------------
    public static Complex add(Complex z1, Complex z2){
        return new Complex(z1.getReal()+z2.getReal(),
                z1.getImaginary()+z2.getImaginary());
    }

    public void add(Complex z){
        this.real += z.getReal();
        this.imag += z.getImaginary();
    }

    public static Complex subtract(Complex z1, Complex z2){
        return new Complex(z1.getReal()-z2.getReal(),
                z1.getImaginary()- z2.getImaginary());
    }

    public void subtract(Complex z){
        this.real -= z.getReal();
        this.imag -= z.getImaginary();
    }
    public static Complex multiply(Complex z1, Complex z2){
        return new Complex(z1.getReal()*z2.getReal() - z1.getImaginary()*z2.getImaginary(),
                z1.getReal()*z2.getImaginary() + z2.getReal()*z1.getImaginary());
    }

    public void multiply(Complex z){
        this.real = this.real*z.getReal() - this.imag * z.getImaginary();
        this.imag = this.real*z.getImaginary() + this.imag*z.getReal();
    }

    public static Complex division(Complex z1, Complex z2){
        return new Complex((z1.getReal()*z2.getReal()+z1.getImaginary()*z2.getImaginary())/(z2.getReal() * z2.getReal() + z2.getImaginary()*z2.getImaginary()),
                (z1.getImaginary()*z2.getReal()-z1.getReal()*z2.getImaginary())/(z2.getReal() * z2.getReal() + z2.getImaginary()*z2.getImaginary()));
    }

    public void division(Complex z){
        this.real = (this.real*z.getReal()+this.imag*z.getImaginary()) / (z.getReal()*z.getReal()+z.getImaginary()*z.getImaginary());
        this.imag = (this.imag*z.getReal()-this.real*z.getImaginary()) / (z.getReal()*z.getReal()+z.getImaginary()*z.getImaginary());
    }

//----------------------------------------------пункт 3------------------------------------------------------------
    public double abs(){
        return Math.sqrt(this.imag*this.imag+this.real*this.real);
    }

    public Complex conjugate(){
        return new Complex(this.real, -this.imag);
    }

    public static boolean equals(Complex z1, Complex z2){
        return z1.getReal() == z2.getReal() && z1.getImaginary() == z2.getImaginary();
    }

    public boolean equals(Complex z){
        return this.real == z.getReal() && this.imag == z.getImaginary();
    }

    public Complex neg(){
        return new Complex(-this.real, -this.imag);
    }

    @Override
    public String toString() {
        if (this.imag > 0){
            return this.real+" + "+this.imag+"i";
        } else{
            return this.real+" - "+Math.abs(this.imag)+"i";
        }
    }

//-------------------------------------------пункт 4--------------------------------------------------------------------
    public static Complex parse(String zstring){
        zstring = zstring.replaceAll(" ", "");

        if (zstring.contains(String.valueOf("+")) || (zstring.contains(String.valueOf("-")) && zstring.lastIndexOf('-') > 0)) {
            String re = "";
            String im = "";
            zstring = zstring.replaceAll("i", "");
            if (zstring.indexOf("+") > 0){
                re = zstring.substring(0, zstring.indexOf("+"));
                im = zstring.substring(zstring.indexOf("+")+1, zstring.length());
                return new Complex(Double.parseDouble(re), Double.parseDouble(im));
            } else if (zstring.lastIndexOf("-")>0){                         // if (zstring.contains("-")){
                re = zstring.substring(0, zstring.lastIndexOf("-"));
                im = zstring.substring(zstring.lastIndexOf("-")+1, zstring.length());

                return new Complex(Double.parseDouble(re), -Double.parseDouble(im));
            }
        }
        return new Complex();
    }
//-------------------------------------------пункт 5--------------------------------------------------------------------
    public Complex pow(double n){
        return new Complex(Math.pow(this.abs(), n)*Math.cos(Math.acos(this.real/this.abs())*n),
                Math.pow(this.abs(), n)*Math.sin(Math.asin(this.real/this.abs())*n));
    }

    public Complex sqrt(){
        return new Complex(Math.sqrt((this.real+this.abs())/2), Math.sqrt((-this.real+this.abs())/2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 && Double.compare(complex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    public double getArgument(){
        return Math.acos(this.real/this.abs());
    }

    public String eString() {
        return this.abs() + " (cos " + this.getArgument() + " + i sin " + this.getArgument() + ")";
    }
//---------------------------------------пункт 6------------------------------------------------------------------------
    public boolean checkReal(){return this.imag == 0;}
    public boolean checkImaginary(){return this.real == 0 && this.imag != 0;}
}
