package com.learn.slidingwindow;

import java.util.HashMap;
import java.util.Map;

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
