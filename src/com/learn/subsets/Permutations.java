package com.learn.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a set of distinct numbers, find all of its permutations.

Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:

{1, 2, 3}
{1, 3, 2}
{2, 1, 3}
{2, 3, 1}
{3, 1, 2}
{3, 2, 1}
If a set has ānā distinct elements it will have n!
n!
 permutations.

Example 1:

Input: [1,3,5]
Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for(int num : nums) {
            // we will take all existing permutations and add the current number
            // to create new permutations
            int n = permutations.size();
            for(int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                // create new permutation by adding the current number at every position
                for(int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermuation = new ArrayList<Integer>(oldPermutation);
                    newPermuation.add(j, num);
                    if(newPermuation.size() == nums.length) {
                        result.add(newPermuation);
                    }
                    else {
                        permutations.add(newPermuation);
                    }
                }

            }
        }


        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
