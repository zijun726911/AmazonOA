package oa.lc696;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        char current=chars[0];

        int count=0;
        int preCount=0;
        int res=0;
        for(char c:chars){

            if(c==current){
                count++;
            }else{//change char

                current=c;
                if(preCount>0){
                    res+=Math.min(preCount,count);
                }

                preCount=count;
                count=1;
            }
        }

        if(preCount>0){
            res+=Math.min(preCount,count);
        }


        return res;
    }
}