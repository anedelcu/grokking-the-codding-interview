package com.learn.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class quiz {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("xywrrmu#p");
        sb.substring(0, sb.length() - 1);
        System.out.println(sb.substring(0, sb.length() - 1));
        String s = "xnsa asdf \"absa dfdf\" sadfs \"asb\" ";
        List<String> res = new ArrayList<>();
        boolean open = false;
        boolean close = false;
        System.out.println(s);

        String ss = "";
        String[] a = s.split(" ");
        for(String str : a) {

            if(str.charAt(0) == '"'){
                open = true;
            }
            if(str.charAt(str.length() - 1) == '"'){
                close = true;
            }

            if((!open && !close)) {
                res.add(str);
            }
            else if(open && close) {
                ss += str;
                res.add(ss);
                ss = "";
                close = false;
                open =false;
            }
            else if(open) {
                ss += str + "  ";
            }


        }
        String[] resArray = new String[res.size()];
        resArray = res.toArray(resArray);
        for (String row: resArray) {
            System.out.println(row);
        }
    }
}
