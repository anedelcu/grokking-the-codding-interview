package com.learn.slidingwindow;
/*
Given an array containing 0s and 1s, if you are allowed
to replace no more than ‘k’ 0s with 1s, find the length
of the longest contiguous subarray having all 1s.

Example 1:
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the
        longest contiguous subarray of 1s having length 6.

Example 2:
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have
     the longest contiguous subarray of 1s having length 9.
 */

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int maxLen = 0;
        int countOnes = 0;
        int start = 0;

        for(int end = 0; end < arr.length; end++) {
            if(arr[end] == 1) {
                countOnes++;
            }
            if(end - start + 1 - countOnes > k) {
                if(arr[start] == 1) {
                    countOnes--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }


        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
