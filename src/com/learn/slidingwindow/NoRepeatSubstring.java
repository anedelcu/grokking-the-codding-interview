package com.learn.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
Given a string, find the length of the longest substring,
which has all distinct characters.

Example 1:
Input: String="aabccbb"
Output: 3
Explanation: The longest substring with distinct characters is "abc".

Example 2:
Input: String="abbbb"
Output: 2
Explanation: The longest substring with distinct characters is "ab".

Example 3:
Input: String="abccde"
Output: 3
Explanation: Longest substrings with distinct characters are "abc" & "cde".
 */
public class NoRepeatSubstring {
    public static int findLength(String str) {
        int maxLen = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end); // insert the 'rightChar' into the map
            maxLen = Math.max(maxLen, end - start + 1); // remember the maximum length so far
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }

}