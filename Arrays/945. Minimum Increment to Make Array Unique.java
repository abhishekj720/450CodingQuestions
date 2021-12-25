//You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

//Return the minimum number of moves to make every value in nums unique.


class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        int count=0;
        
        for(int i=0; i < nums.length-1; i++)
        {
            while(nums[i] >= nums[i+1])
            {
                nums[i+1] += 1;
                count++;
            }
        }
        
        return count;
    }
}
