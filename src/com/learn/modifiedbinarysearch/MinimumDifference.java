package com.learn.modifiedbinarysearch;
/*
Given an array of numbers sorted in ascending order, find the element in the array that has the minimum
difference with the given ‘key’.

Example 1:
Input: [4, 6, 10], key = 7
Output: 6
Explanation: The difference between the key '7' and '6' is minimum than any other number in the array

Example 2:
Input: [4, 6, 10], key = 4
Output: 4

Example 3:
Input: [1, 3, 8, 10, 15], key = 12
Output: 10

Example 4:
Input: [4, 6, 10], key = 17
Output: 10
 */
public class MinimumDifference {

  public static int searchMinDiffElement(int[] arr, int key) {
    if(key < arr[0]) {
      return arr[0];
    }
    if(key > arr[arr.length - 1]) {
      return arr[arr.length - 1];
    }
    int minDiff = Integer.MAX_VALUE;
    int start = 0;
    int end = arr.length - 1;
    while(start <= end) {
      int mid = start + (end - start) / 2;
      if(arr[mid] == key) {
        return arr[mid];
      }
      else if(key < arr[mid]) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    if((arr[start] - key) < (key - arr[end])) {
      return arr[start];
    }
    return arr[end];
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}