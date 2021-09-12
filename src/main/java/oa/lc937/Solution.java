package oa.lc937;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    //https://leetcode.com/problems/reorder-data-in-log-files/

    public String[] reorderLogFiles(String[] logs) {

        List<String> digitLogs=new ArrayList<>();
        List<String> letterLogs=new ArrayList<>();

        for (String log : logs) {
            char lastChar = log.charAt(log.length() - 1);
            if(Character.isDigit(lastChar)){ //Digit-logs
                digitLogs.add(log);
            }else{//Letter-logs
                letterLogs.add(log);
            }
        }

        letterLogs.sort((str1,  str2)->{

            int firstSpace1 = str1.indexOf(' ');
            int firstSpace2 = str2.indexOf(' ');

            int contentCmpRes=str1.substring(firstSpace1+1).compareTo(str2.substring(firstSpace2+1));
            if(contentCmpRes!=0) {
                return contentCmpRes;
            }else {
                return str1.substring(0,firstSpace1).compareTo(str2.substring(0,firstSpace2));
            }

        });



        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);



    }
}
