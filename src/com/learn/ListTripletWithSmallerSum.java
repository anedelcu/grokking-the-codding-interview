package com.learn.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array arr of unsorted numbers and a target sum,
count all triplets in it such that arr[i] + arr[j] + arr[k] < target
where i, j, and k are three different indices. Write a function to
return the count of such triplets.

Example 1:
Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Example 2:
Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class ListTripletWithSmallerSum {
    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        if(arr.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            int left  = i + 1;
            int right = arr.length - 1;

            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum < target) {
                    for(int index = right; index > left; index--) {
                        triplets.add(Arrays.asList(arr[i], arr[left], arr[index]));
                    }
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(ListTripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(ListTripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}