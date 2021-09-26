package oa.oa;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    //Caesar Code, ascii向前平移k个
    public String oa1(String str, int k) {
        k=k%26;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int offset=chars[i]-'A';
            int newOffset= (offset-k+26)%26;
            chars[i]=(char)('A'+newOffset);
        }

        return new String(chars);

    }



    public static void main(String[] args) {
        String res = new Solution().oa1("ABCDEFG", 1);
        System.out.println(res);
    }
}
