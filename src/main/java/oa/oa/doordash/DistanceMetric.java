package oa.oa.doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceMetric {
   // https://github.com/wisdompeak/LintCode/tree/master/Others/327.Distance-Metrics
    public int [] solve(int [] arr){
        Map<Integer, List<Integer>> map=new HashMap<>();


        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);

        }

        int []res=new int[arr.length];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            List<Integer> indexes = entry.getValue();
            int n=indexes.size();
            int []pre=new int[n];
            int []suf=new int[n];

            for (int i = 1; i < n; i++) {
                pre[i]=pre[i-1]+i*(indexes.get(i)-indexes.get(i-1));
            }

            for (int i=n-2; i >=0; i--) {
                suf[i]=suf[i+1]+(n-i-1)*(indexes.get(i+1)-indexes.get(i));
            }

            for (int i = 0; i < n ; i++) {
                res[indexes.get(i)]=pre[i]+suf[i];
            }
        }


        return res;


    }


    public static void main(String[] args) {
        int[] solve = new DistanceMetric().solve(new int[]{1, 2, 1, 1, 2, 3});

        for (int i = 0; i < solve.length; i++) {
            System.out.println(solve[i]);
        }
    }
}
