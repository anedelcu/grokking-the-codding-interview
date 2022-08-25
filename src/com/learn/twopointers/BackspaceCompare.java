package com.learn.twopointers;

public class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder();
        for(int i  = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != '#') {
                sb1.append(str1.charAt(i));
            }
            else if(str1.charAt(i) == '#') {
                sb1 =  sb1.deleteCharAt((sb1.length() - 1));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i  = 0; i < str2.length(); i++) {
            if(str2.charAt(i) != '#') {
                sb2.append(str2.charAt(i));
            }
            else if(str2.charAt(i) == '#') {
                sb2 = sb2.deleteCharAt((sb2.length() - 1));
            }
        }
        return sb2.toString().equals(sb1.toString());
    }

    public static void main(String[] args) {
        String str1="xp#", str2="xyz##"; // true
        System.out.println(compare(str1, str2));
        System.out.println(compare("xy#z", "xzz#")); // true
    }
}