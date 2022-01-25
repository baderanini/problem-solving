class Solution {
    public int checkRecord(int n) {
        int[][][] memo = new int[n+1][2][3];
        for(int[][] subArr: memo)
            for(int[] subSubArr: subArr)
                Arrays.fill(subSubArr, -1);
        return dfs(n, 1, 0, memo);
    }
    
    int dfs(int n, int remA, int lSeq, int[][][] memo) {
        if(n == 0)
            return 1;
        if(memo[n][remA][lSeq] != -1)
            return memo[n][remA][lSeq];
        int withP = dfs(n-1, remA, 0, memo) % 1000000007;
        int withL = lSeq > 1 ? 0 : dfs(n-1, remA, lSeq+1, memo) % 1000000007;
        int withA = remA == 0 ? 0 : dfs(n-1, remA-1, 0, memo) % 1000000007;
        
        int res = ((withP + withL) % 1000000007 + withA) % 1000000007;
        memo[n][remA][lSeq] = res;
        return res;
    }
}