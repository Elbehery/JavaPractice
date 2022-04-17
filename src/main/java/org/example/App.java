package org.example;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        if (a == null || b == null)
            throw new NullPointerException("Input Arrays can not be null");

        if (a.isEmpty() || b.isEmpty())
            throw new IllegalArgumentException("Input Arrays can not be empty");

        if (a.size() != b.size())
            throw new IllegalArgumentException("Input Arrays must have equal size");

        List<Integer> result = new ArrayList<>(a.size());

        // iterate over the input and compare both string at the same index.
        for (int i = 0; i < a.size(); i++) {
            // diff size means can not anagrams
            if (a.get(i).length() != b.get(i).length()) {
                result.add(i, -1);
                continue;
            }

            Map<Character, Integer> counterMap = new HashMap<>();
            // dump the first string into the map and count char occurrence
            for (Character c : a.get(i).toCharArray()) {
                if (counterMap.containsKey(c)) {
                    counterMap.put(c, counterMap.get(c) + 1);
                } else {
                    counterMap.put(c, 1);
                }
            }

            // remove matching chars from the map
            for (Character c : b.get(i).toCharArray()) {
                if (counterMap.containsKey(c)) {
                    int count = counterMap.get(c);
                    count--;
                    if (count == 0) {
                        counterMap.remove(c);
                    } else {
                        counterMap.put(c, count);
                    }
                }
            }

            // sum the occurence to get the diff
            int diff = 0;
            for (Integer v : counterMap.values()) {
                diff += v;
            }
            result.add(i, diff);
        }
        return result;
    }

    public static String firstRepeatingLetter(String s) {
        // Write your code here
        if (s == null)
            throw new NullPointerException();
        if (s.isEmpty())
            throw new IllegalArgumentException();

        // 1-sort a copy from the string to find the duplicates
        // 2-add the duplicates ONLY to Set
        // 3-iterate over the original string, and find first char that exist in the Set

        Set<Character> duplicteSet = new HashSet<>();
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        for (int i = 1; i < sArray.length; i++) {
            if (sArray[i] == sArray[i - 1]) {
                duplicteSet.add(sArray[i]);
            }
        }

        // find first occurrence
        for (Character c : s.toCharArray()) {
            if (duplicteSet.contains(c)) {
                return c.toString();
            }
        }
        return "";
    }


    public static void main(String[] args) {

        String[] stringArray = new String[]{"a", "jk", "abb", "mn", "abc"};
        List<String> left = Arrays.asList(stringArray);

        stringArray = new String[]{"bb", "kj", "bbc", "op", "def"};
        List<String> right = Arrays.asList(stringArray);

        List<Integer> res = getMinimumDifference(left, right);
        System.out.println(res);
    }
}
