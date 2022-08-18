package com.learn.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string and a pattern, find all anagrams of the pattern in the given string.
Every anagram is a permutation of a string. As we know, when we are not allowed to
repeat characters while finding permutations of a string, we get N!
N!
 permutations (or anagrams) of a string having N
N
 characters. For example, here are the six anagrams of the string “abc”:

abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern
in the given string.

Example 1:
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Example 2:
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int start = 0;
        int matches = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if(map.get(c) == 0) {
                    matches++;
                }
            }
            if(matches == map.size()) {
                resultIndices.add(start);
            }
            if(end >= pattern.length() - 1) {
                char leftChar = str.charAt(start++);
                if(map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matches--;
                    }
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}

