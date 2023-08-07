package com.examples.customexceptions.runtime;

public class RunTimeCustomException {

    public static void main(String[] args) {
        arithmeticException();
        nullPointerException();
        numberFormatException();
        arrayIndexOutOfBoundsException();
        stringIndexOutOfBoundsException();
    }

    private static void arithmeticException() {

        try {
            int ans = 2/0;
        } catch (Exception e) {
            throw new ArithmeticCustomException("Mathematical Invalid Operation");
        }
    }

    private static void nullPointerException() {

        String ans = null;
        try {
            System.out.println("String length: "+ans.length());
        } catch (Exception e) {
            throw new NullPointerCustomException("Null pointer exception occurred");
        }
    }

    private static void numberFormatException() {
        String s="abc";
        try {
            int i=Integer.parseInt(s);
        } catch (Exception e) {
            throw new NumberFormatCustomException("Invalid Number");
        }
    }

    private static void arrayIndexOutOfBoundsException() {
        try {
            int a[]=new int[5];
            a[10]=50;
        } catch (Exception e) {
            throw new ArrayIndexCustomException("Invalid array size assigned");
        }
    }

    private static void stringIndexOutOfBoundsException() {
        try {
            String str = "Hello, World!";
            char character = str.charAt(15);
            System.out.println("Character: "+character);
        } catch (Exception e) {
            throw new StringIndexCustomException("Invalid String size assigned");
        }
    }

}
