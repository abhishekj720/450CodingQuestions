//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

//Note: You can only move either down or right at any point in time.



class Solution {
    public int minPathSum(int[][] grid) {
        
        int dp[][] = new int[grid.length][grid[0].length];
        
        int sum=0;
        for(int i=0; i < grid[0].length; i++)
        {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        
        if(grid.length == 1)
            return sum;
        
        sum =0;
        for(int i=0; i < grid.length; i++)
        {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        
        if(grid[0].length == 1)
            return sum;
        
        for(int i=1; i < grid.length; i++)
        {
            for(int j=1; j < grid[i].length; j++)
            {
                if(dp[i-1][j] > dp[i][j-1])
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                
                else
                    dp[i][j] = dp[i-1][j] + grid[i][j];
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
        
        
    }
}
