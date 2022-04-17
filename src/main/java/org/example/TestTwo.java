package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTwo {

    public static String rollTheString(String s, List<Integer> roll) {
        // Write your code here
        if (s == null || roll == null)
            throw new NullPointerException();

        if (s.isEmpty() || roll.isEmpty())
            throw new IllegalArgumentException();

        char[] rollArray = s.toCharArray();
        for (Integer limit : roll) {
            for (int i = 0; i < limit; i++) {
                rollArray[i] = (char) (((rollArray[i] - 'a' + 1) % 26) + 'a');
            }
        }
        return String.valueOf(rollArray);
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
