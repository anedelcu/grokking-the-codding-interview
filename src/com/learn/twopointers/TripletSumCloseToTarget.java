package com.learn.twopointers;

import java.util.Arrays;

/*
Given an array of unsorted numbers and a target number, find a triplet in the array
whose sum is as close to the target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Example 1:
Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Example 2:
Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

Example 3:
Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        if(arr.length < 3) {
            throw new IllegalArgumentException();
        }
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right) {
                int tempSum = arr[i] + arr[left] + arr[right];
                if(Math.abs(targetSum - tempSum) < Math.abs(closestSum) ||
                        (Math.abs(targetSum - tempSum) == Math.abs(closestSum) &&
                                targetSum - tempSum > closestSum)) {
                    closestSum = targetSum - tempSum;
                }
                if(tempSum == targetSum) {
                    return targetSum;
                }
                else if(tempSum > targetSum) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return targetSum - closestSum;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}