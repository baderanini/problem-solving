class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] memo = new int[n+1][7][16];
        for(int[][] subArr: memo)
            for(int[] subSubArr: subArr)
                Arrays.fill(subSubArr, -1);
        return dfs(rollMax, n, 0, 0, memo);
    }
    
    int dfs(int[] rollMax, int n, int prev, int constraint, int[][][] memo) {
        if(n == 0)
            return 1;
        
        if(memo[n][prev][constraint] != -1)
            return memo[n][prev][constraint];
        
        int res = 0;
        for(int i = 1 ; i <= 6 ; i++) {
            int newConstraint = i == prev ? constraint : rollMax[i-1];
            if(newConstraint > 0) {
                res = (res + dfs(rollMax, n-1, i, newConstraint - 1, memo) % 1000000007) % 1000000007;
            }
        }
        
        memo[n][prev][constraint] = res;
        return res;
    }
}