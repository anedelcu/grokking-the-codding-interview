package com.learn.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
Given a string and a pattern, find the smallest substring in the given
 string which has all the character occurrences of the given pattern.

Example 1:
Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Example 2:
Input: String="aabdec", Pattern="abac"
Output: "aabdec"
Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"

Example 3:
Input: String="abdbca", Pattern="abc"
Output: "bca"
Explanation: The smallest substring having all characters of the pattern is "bca".

Example 4:
Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.
 */
public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int minLen  = str.length() + 1;
        int subStrStart = 0;
        int matches = 0;
        String res = "";

        for(char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
                if(map.get(rightChar) >= 0) {
                    matches++;
                }
            }
            while(matches == pattern.length()) {
                if(minLen > end - start + 1) {
                    minLen = end - start + 1;
                    subStrStart = start;
                }

                char leftChar = str.charAt(start++);
                if(map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matches--;
                    }
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                }
            }

        }
        return minLen > str.length() ? "" : str.substring(subStrStart, subStrStart + minLen);
    }


    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abac"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}
