/*  Input: nums = [0,1,2,4,5,7]
    Output: ["0->2","4->5","7"]  */
package com.javanotes;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNum {

    public static void main(String[] args) {
        int a[] = {0, 1, 2, 4, 5, 7};
        System.out.println(rangeFinder(a));
    }

    private static List<String> rangeFinder(int[] a) {
        List<String> stringList = new ArrayList<String>();

        for (int i = 0; i<a.length ; i++) {

            int start = a[i];

            while (i< a.length-1 && a[i]+1 == a[i+1]) {
                i++;
            }

            int end = a[i];

            stringList.add(start == end ? start+"" : start+"->"+end);
        }
        return stringList;
    }
}
