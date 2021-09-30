package template;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
      //monotonic queue
      //end to front : nums[i] strict ascending order
      //queue stores index
      int n=nums.length;
      int[] res= new int [n-k+1]; int j=0;//j to index res[]
      Deque<Integer> q=new LinkedList<>();
      for(int i=0;i<n;i++){
        while(!q.isEmpty()&& nums[q.peekLast()]<=nums[i]) q.pollLast();
        // nums[q.peekLast()]>nums[i]
        q.offerLast(i);

        if(i-k+1>=0) res[j++] = nums[q.peekFirst()];
        if(q.peekFirst() == i-k+1) q.pollFirst(); //we only need to remove a element in the queue when the first ele in the window is the window maximum value; i-k+1<0 scenario  condition always false

      }

      return res;
    }

}
