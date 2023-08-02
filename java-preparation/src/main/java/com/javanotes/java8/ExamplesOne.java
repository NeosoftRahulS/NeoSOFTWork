/* https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html */
package com.javanotes.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class ExamplesOne {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");

        //1) Java8: Counting Empty String
        long count = stringList.stream().filter(x-> x.isEmpty()).count();
        System.out.println("Empty String: "+count);

        //2) Java8: Count String whose length is more than three
        long countMoreThanThree = stringList.stream().filter(data -> data.length() > 3).count();
        System.out.println("\nCount more than three: "+countMoreThanThree);

        //3) Java8: Count number of String which starts with "a"
        long startsWithA = stringList.stream().filter(data -> data.startsWith("a")).count();
        System.out.println("\nCount starts with 'a': "+startsWithA);

        //4) Java8: Remove all empty Strings from List
        List<String> filtered = stringList.stream().filter(x-> !x.isEmpty()).collect(Collectors.toList());
        System.out.println("\nFiltered collection: "+filtered);

        //5) Java 8: Create a List with String more than 2 characters
        List<String> moreThanTwoChar =stringList.stream().filter(string -> string.length()>2).collect(Collectors.toList());
        System.out.println("\nList more than 2 characters: "+moreThanTwoChar);

        //6) Java8: Convert String to uppercase and Join them with comma
        List<String> g7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String upperCase = g7.stream().map(string -> string.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println("\nUpperCase String: "+upperCase);

        //7) Java 8: Create a List of the square of all distinct numbers
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> integers = numbers.stream().distinct().map(num -> num*num).collect(Collectors.toList());
        System.out.println("\nSquare list: "+integers);

        //8) Java 8: Get count, min, max, sum, and the average for numbers
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics intSummaryStatistics =primes.stream().mapToInt(x -> (x)).summaryStatistics();
        System.out.println("\nCount: "+intSummaryStatistics.getCount());
        System.out.println("Sum: "+intSummaryStatistics.getSum());
        System.out.println("Min: "+intSummaryStatistics.getMin());
        System.out.println("Avg: "+intSummaryStatistics.getAverage());
        System.out.println("Max: "+intSummaryStatistics.getMax());

    }
}
