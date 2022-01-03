//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

class Solution {
    
    public void DFS(int x,int y,int r, int c, boolean[][] visited, char[][] grid)
    {
        int[][] d = {{0,-1},{-1,0},{0,1},{1,0}};
        
        if(x< 0 || y< 0 || x>= r || y>= c || visited[x][y] == true || grid[x][y] == '0')
        {
            return;
        }
        
        visited[x][y] = true;
        for(int k=0; k< 4; k++)
        {
            int nx = x + d[k][0];
            int ny = y + d[k][1];
            DFS(nx,ny,r,c,visited,grid);
        }
        
    }
    
    public int numIslands(char[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;
        boolean visited[][] = new boolean[r][c];
        
        for(boolean[] i : visited)
            Arrays.fill(i, false);
        
        int count =0;
        
        for(int i=0; i< r; i++)
            for(int j=0; j< c; j++)
            {   
                if(grid[i][j] == '1' && visited[i][j] == false)
                {
                    DFS(i,j,r,c,visited,grid);
                    count++;
                }
                    
            }
        
        return count;
}
    
}
