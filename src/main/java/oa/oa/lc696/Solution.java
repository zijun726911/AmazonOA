package oa.oa.lc696;

public class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int res=0;
        for (int i = 0; i < chars.length-1; i++) {
             if(chars[i]!=chars[i+1]){
                 int l=i-1;
                 int r=i+2;
                 res++;
                 while (l>=0&&r<chars.length&&chars[l]==chars[l+1]&&chars[r]==chars[r-1]){
                     res++;
                     l--;
                     r++;

                 }
                i=r-2;
             }
        }

        return res;
    }
}
