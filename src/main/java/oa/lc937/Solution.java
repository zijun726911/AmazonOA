package oa.lc937;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    //https://leetcode.com/problems/reorder-data-in-log-files/

    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String> letterQueue = new PriorityQueue((o1,  o2)->{
            String str1=(String) o1;
            String str2=(String) o2;

            String[] s1 = str1.split(" ", 2);
            String[] s2 = str2.split(" ", 2);

            String id1=s1[0];
            String content1=s1[1];
            String id2=s2[0];
            String content2=s2[1];

            int contentCmpRes=content1.compareTo(content2);
            if(contentCmpRes!=0) {
                return contentCmpRes;
            }else {
                return id1.compareTo(id2);
            }

        });


        List<String> digitLogs=new ArrayList<>();
        for (String log : logs) {
            char lastChar = log.charAt(log.length() - 1);
            if(Character.isDigit(lastChar)){ //Digit-logs
                digitLogs.add(log);
            }else{//Letter-logs
                letterQueue.offer(log);
            }
        }

        List<String> res=new ArrayList<>();
        while (!letterQueue.isEmpty()){
            res.add(letterQueue.poll());
        }

        res.addAll(digitLogs);

        return res.toArray(new String[0]);



    }
}
