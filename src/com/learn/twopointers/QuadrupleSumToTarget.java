package com.learn.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.

Example 1:
Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.

Example 2:
Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
 */

public class QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int  i = 0; i < arr.length - 3; i++) {
            if( i > 0 && arr[i] == arr[i -1]) {
                continue;
            }
            for(int j = i + 1; j < arr.length - 2; j++) {
                if(j > i + 1 && arr[j] == arr[j -1]) {
                    continue;
                }
                searchPairs(arr, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = arr.length - 1;
        while(left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if(sum == targetSum) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left -1]) {
                    left++;
                }
                while(left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            }
            else if(sum < targetSum){
                left++;
            }
            else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }

}
