package com.learn.subsets;

import java.util.ArrayList;
import java.util.List;
/*
Given an expression containing digits and operations (+, -, *), find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.

Example 1:

Input: "1+2*3"
Output: 7, 9
Explanation:
  1+(2*3) => 7
  (1+2)*3 => 9

Example 2:

Input: "2*3-4-5"
Output: 8, -12, 7, -7, -3
Explanation:
  2*(3-(4-5)) => 8
  2*(3-4-5) => -12
  2*3-(4-5) => 7
  2*(3-4)-5 => -7
  (2*3)-4-5 => -3
 */
public class EvaluateExpression {

    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();

        // base case: if the input string is a number, pare and add it to the input
        if(!input.contains("+") && !input.contains("*") && !input.contains("-")) {
            result.add(Integer.valueOf(input));
        }
        else {
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(!Character.isDigit(c)) {
                    List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));

                    for(int part1 : leftParts) {
                        for (int part2 : rightParts) {
                            if(c == '+') {
                                result.add(part1 + part2);
                            }
                            else if(c == '-') {
                                result.add(part1 -part2);
                            }
                            else if( c == '*') {
                                result.add(part1 * part2);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
