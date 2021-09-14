package oa.lc1109;

import java.util.Arrays;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] res=new int[n+1];
        for(int[] booking:bookings){
            res[booking[0]-1]+=booking[2];
            res[booking[1]]-=booking[2];

        }

        for (int i = 1; i < res.length; i++) {
            res[i]+=res[i-1];
        }

        return Arrays.copyOf(res,n);
    }
}