//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//https://leetcode.com/problems/house-robber/



class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
        {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        
        
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        dp[1] = nums[1];
        
        
        
        int max = -1;
        
        
        for(int i=2; i< nums.length ; i++)
        {
           for(int j=0; j < i-1; j++)
           {
               max = Math.max(dp[i-1], dp[j] + nums[i]);
               
               if(max > dp[i])
               {
                   dp[i] = max;
               }
           }
        }
        
        //System.out.println(dp[nums.length-1]);
        int a = dp[nums.length-1];
        
        return a;
    }
}
