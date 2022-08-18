package com.learn.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string.
For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters, it will have n!
n! permutations.

Example 1:
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Example 3:
Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Example 4:
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        int start = 0;

        for(char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if(map.get(c) == 0) {
                    count++;
                }
            }

            if(count == map.size()) {
                return true;
            }
            if(end >= pattern.length() - 1) {
                char leftChar = str.charAt(start++);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0) {
                        count--;
                    }
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                }
                //start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }
}