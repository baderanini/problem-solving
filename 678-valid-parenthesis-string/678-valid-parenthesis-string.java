class Solution {
    public boolean checkValidString(String s) {
        boolean[][] memo = new boolean[s.length() + 1][s.length() + 1];
        for(boolean[] sub: memo)
            Arrays.fill(sub, true);
        return dfs(s, 0, 0, memo);
    }
    
    boolean dfs(String s, int i, int openPars, boolean[][] memo) {
        if(i == s.length())
            return openPars == 0;
        
        if(memo[i][openPars] == false)
            return false;
        
        boolean result = false;
        char c = s.charAt(i);
        if(c == '*') {
            result = dfs(s, i+1, openPars, memo) || (openPars > 0 ? dfs(s, i+1, openPars-1, memo) : false) || dfs(s, i+1, openPars+1, memo);
        } else if(c == ')') {
            if(openPars == 0) {
                result = false;
            }
            else {
                result = dfs(s, i+1, openPars-1, memo);
            }
        } else if(c == '(') {
            result = dfs(s, i+1, openPars+1, memo);
        }
        
        memo[i][openPars] = result;
        return result;
    }
}