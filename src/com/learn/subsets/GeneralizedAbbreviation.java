package com.learn.subsets;


import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        int n = word.length();
        dfs(result, word,"", 0, 0);
        return result;
    }
    private static void dfs(List<String> result,String word, String abv, int pos, int count){
        if(pos == word.length()) {
            if(count > 0) {
                abv += count;
            }
            result.add(abv);
            return;
        }
        dfs(result, word, abv, pos + 1, count + 1);
        //dfs(result, word, abv + (count > 0 ? count : "" + word.charAt(pos)), pos + 1, 0);
        if(count > 0){
            dfs(result, word, abv + count + word.charAt(pos), pos + 1, 0);
        }
        else {
            dfs(result, word, abv + word.charAt(pos), pos + 1, 0);
        }
    }

    public static void main(String[] args) {
        List<String> result = generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
