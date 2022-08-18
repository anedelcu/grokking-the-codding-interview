package com.learn.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Given a string and a list of words, find all the starting indices of
substrings in the given string that are a concatenation of all the given
words exactly once without any overlapping of words. It is given that all
words are of the same length.

Example 1:
Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Example 2:
Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".
 */
public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Integer> resList = new ArrayList<>();
        int countWords = words.length;
        int wordLen  = words[0].length();

        for (int i = 0; i <= str.length() - countWords * wordLen; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for(int j = 0; j < countWords; j++) {
                int nextIdx = i + j * wordLen;
                String word = str.substring(nextIdx, nextIdx + wordLen);
                if(!map.containsKey(word)) {
                    break;
                }

                wordsSeen.put(word, wordsSeen.getOrDefault(word,0) + 1);

                if(wordsSeen.get(word) > map.getOrDefault(word, 0)) {
                    break;
                }

                if(j + 1 == countWords) {
                    resList.add(i);
                }

            }
        }
        return resList;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}