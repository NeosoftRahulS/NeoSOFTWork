package com.javanotes;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverseVowels(input);
        System.out.println("Original String: " + input);
        System.out.println("String with Reversed Vowels: " + reversed);
    }

    public static String reverseVowels(String str) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        return str.chars().mapToObj(ch -> (char) ch).collect(StringBuilder::new, (sb, ch) -> {
                    if (vowels.contains(ch)) {
                        sb.insert(0, ch);
                    }
                }, StringBuilder::append).toString();
    }
}
