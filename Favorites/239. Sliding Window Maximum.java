//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

//Return the max sliding window.

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        dq.offerLast(0);
        if(k == 1)
            return nums;
        
        int j=0;
        for(int i=1; i < nums.length; i++)
        {   
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i] )
            {
                dq.pollLast();
            }
            
            dq.offerLast(i);
            
            if(dq.peekFirst() < i-k+1)
            {
                dq.pollFirst();
            }
            
            if(i >= k-1)
            {
                res[j] = nums[dq.peekFirst()];
                j++;
            }
            
            
        }
        
        return res;
        
         
    }
}
