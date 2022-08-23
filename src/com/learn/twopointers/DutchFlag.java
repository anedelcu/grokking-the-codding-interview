package com.learn.twopointers;

import java.util.Arrays;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.

Example 1:
Input: [1, 0, 2, 1, 0]
Output: [0, 0, 1, 1, 2]

Example 2:
Input: [2, 2, 0, 1, 2, 0]
Output: [0, 0, 1, 2, 2, 2,]
 */

public class DutchFlag {
    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        for(int  i = 0; i <= right;) {
            if(arr[i] == 0) {
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
                i++;
                left++;
            }
            else  if(arr[i] == 1) {
                i++;
            }
            else {
                int temp = arr[right];
                arr[right] = arr[i];
                arr[i] = temp;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
