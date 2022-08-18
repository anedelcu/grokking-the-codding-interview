package com.learn.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter,
 find the length of the longest substring having the same letters after replacement.

Example 1:
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".

Example 2:
Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".

Example 3:
Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int maxLen = 0;
        int start = 0;
        int countChar = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int end  = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            countChar = Math.max(countChar, map.get(c));

            if(end - start + 1 - countChar > k) {
                char leftChar = str.charAt(start);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                start++;

            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2)); // 5
        System.out.println(CharacterReplacement.findLength("abbcb", 1)); // 4
        System.out.println(CharacterReplacement.findLength("abccde", 1)); // 3
    }
}