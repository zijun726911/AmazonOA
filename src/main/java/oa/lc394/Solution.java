package oa.lc394;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb=new StringBuilder();

        List<String> list=new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='a'&&c<='z'){
                sb.append(c);
            }else if (c>='1'&& c<='9'){
                int l=s.indexOf('[',i);
                int r=-1;
                int lNum=1;

                //find matched right bracket
                for (int j = l+1; j < s.length(); j++) {
                    if (s.charAt(j)=='['){
                        lNum++;
                    }else if(s.charAt(j)==']'){
                        lNum--;
                        if(lNum==0){
                            r=j;
                            break;
                        }
                    }
                }


                int n = Integer.parseInt(s.substring(i,l )) ;
                String decodedSubString = decodeString(s.substring(l + 1, r));
                sb.append(decodedSubString.repeat(n));
                i=r;
            }else {
                System.out.println("error");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String solution = new Solution().decodeString("abc3[cd]xyz");
        System.out.println(solution);
    }
}
