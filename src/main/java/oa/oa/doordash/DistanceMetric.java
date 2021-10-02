package oa.oa.doordash;

public class DistanceMetric {
    public int [] solve(int [] arr){
        int []res= new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    int diff=Math.abs(i-j);
                    res[i]+=diff;
                    res[j]+=diff;

                }
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
