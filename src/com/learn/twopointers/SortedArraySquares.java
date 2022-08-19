package com.learn.twopointers;
/*
Given a sorted array, create a new array containing squares of
all the numbers of the input array in the sorted order.

Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Example 2:
Input: [-3, -1, 0, 1, 2]
Output: [0, 1, 1, 4, 9]
 */

public class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int left = 0;
        int right =  arr.length - 1;
        int index = arr.length - 1;
        while(left <= right) {
            if(arr[left] * arr[left] >= arr[right] * arr[right]) {
                squares[index] = arr[left] * arr[left];
                left++;
            }
            else {
                squares[index] = arr[right] * arr[right];
                right--;
            }
            index--;
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
