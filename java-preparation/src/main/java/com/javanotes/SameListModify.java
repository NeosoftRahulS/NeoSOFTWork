package com.javanotes;

import java.util.Arrays;

public class SameListModify {

    public static void main(String[] args) {
      greaterThan();
    }

    private static void greaterThan() {
        int a[] = {7, 8, 9, 10, 11, 12, 13, 14, 15};
        int temp;

        for (int i = 0; i<a.length; i++) {

            for (int j = i+1; j<a.length; j++) {
                if(a[j]>=12) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i]=temp;
                }
            }
        }
        Arrays.stream(a).forEachOrdered( data ->System.out.print(data+", "));
    }
}
