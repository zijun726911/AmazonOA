package template;

import java.util.Stack;

public class MonotonicStack {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack <Integer> st=new Stack<>();
        int []res=new int[n];
        for( int i=2*n-1;i>=0;i--){
            int num=nums[i%n];
            while(!st.isEmpty()&& num>=st.peek()) st.pop();

            //num<st.peek()
            if(st.isEmpty()){
                res[i%n]=-1;
            }else{
                res[i%n]=st.peek();
            }

            st.push(num);

        }


        return res;
    }
}
