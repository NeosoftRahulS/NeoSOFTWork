package com.javanotes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Examples {

    public static void main(String[] args) {
        biggestNumArray();
        reverseString();
        frequencyOfChars();
        duplicateChars();
        wordCountHashMap();
        charCountHashMap();
        firstWordCapital();
        everyWordCapital();

    }


    /* biggestNumArray */
    private static void biggestNumArray() {
        int a[] = {99, 103, 105, 55, 90, 77};
        int biggestNum = a[0];

        for (int i = 1; i<a.length ; i++) {

            if(a[i]>biggestNum) {
                biggestNum = a[i];
            }
        }
        System.out.println("Biggest Number: "+biggestNum);
    }

    /* reverseString */
    private static void reverseString() {
        String sentence = "Java Programs";
        String reverseString = "";

        for (int i = sentence.length()-1; i>=0; i--){
            reverseString+=sentence.charAt(i);
        }
        System.out.println("\nOriginal String: "+sentence+"\nReverse String: "+reverseString);
    }

    /* frequencyOfChars */
    private static void frequencyOfChars() {
        String sentence = "Picture Perfect";

        int[] freq = new int[sentence.length()];
        char[] charString = sentence.toCharArray();

        for (int i = 0; i<charString.length; i++) {
            freq[i]=1;

            for (int j=i+1; j<charString.length; j++) {

                if(charString[i]==charString[j]) {
                    freq[i]++;
                    charString[j]='0';
                }
            }
        }
        System.out.println("Frequency of characters are below: \n");

        for (int k=0; k<freq.length; k++) {
            if(charString[k]!='0' && charString[k]!=' ') {
                System.out.println(charString[k]+"-"+freq[k]);
            }
        }
    }

    /* duplicateChars */
    private static void duplicateChars() {
        String sentence = "Great Responsibility";
        char[] charString = sentence.toCharArray();
        int count;

        for (int i=0; i<charString.length ; i++) {
            count=1;

            for (int j=i+1; j<charString.length; j++) {
                if(charString[i]==charString[j] && charString[i]!=' ') {
                    count++;
                    charString[j]='0';
                }
            }

            if(count>1 && charString[i]!='0') {
                System.out.println(charString[i]);
            }
        }
    }

    /* wordCountHashMap */
    private static void wordCountHashMap() {
        System.out.println("\nWord count is as below: ");
        String sentence = "Audi is car and Pulsar is Bike";
        Map<String, Integer> hashMap = new HashMap<>();

        Arrays.asList(sentence.split("\\s")).forEach(word
                -> hashMap.put(word, hashMap.containsKey(word) ? hashMap.get(word)+1 : 1));
        System.out.println(hashMap);
    }

    /* charCountHashMap */
    private static void charCountHashMap() {
        System.out.println("\nWord count is as below: ");
        String sentence = "Audi is car and Pulsar is Bike";
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char character: sentence.toCharArray()) {
            hashMap.put( character, hashMap.containsKey(character) ? hashMap.get(character)+1 : 1);
        }
        System.out.println(hashMap);
    }

    /* firstWordCapital */
    private static void firstWordCapital() {
        String input = "adams bridge";
        System.out.println("\n"+input.substring(0, 1).toUpperCase()+input.substring(1));
    }

    /* everyWordCapital */
    private static void everyWordCapital() {
        String sentence = "sun is biggest star in our galaxy";
        String capitalize = "";

        for (String word : sentence.split("\\s")) {
            capitalize+=word.substring(0,1).toUpperCase()+word.substring(1)+" ";
        }

        System.out.println(capitalize);
    }

}
