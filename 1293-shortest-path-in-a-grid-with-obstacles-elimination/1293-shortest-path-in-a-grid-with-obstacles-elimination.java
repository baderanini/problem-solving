class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][][] memo = new int[grid.length][grid[0].length][k+1];
        int result = dfs(grid, 0, 0, k, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    int IN_CALL_STACK = 2, OBSTACLE = 1;
    int dfs(int[][] grid, int i, int j, int k, int[][][] memo) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;
        
        if(memo[i][j][k] != 0) {
            return memo[i][j][k];
        }
        
        if(k < 0)
            return Integer.MAX_VALUE;
        if(k == 0 && grid[i][j] == OBSTACLE)
            return Integer.MAX_VALUE;
        
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return 0;
        
        if(grid[i][j] == IN_CALL_STACK)
            return Integer.MAX_VALUE;
        
        int cellVal = grid[i][j];
        grid[i][j] = IN_CALL_STACK;
        
        int res = 0;
        if(cellVal == OBSTACLE)
            k--;
        
        int up =    dfs(grid, i-1, j, k, memo);
        int down =  dfs(grid, i+1, j, k, memo);
        int left =  dfs(grid, i, j-1, k, memo);
        int right = dfs(grid, i, j+1, k, memo);
        
        int vertical = Math.min(up, down), horizontal = Math.min(left, right);
        int total = Math.min(vertical, horizontal);
        
        int result = total == Integer.MAX_VALUE ? Integer.MAX_VALUE : (1 + total); 
        
        memo[i][j][k] = result;
        grid[i][j] = cellVal;
        return result;
    }
}