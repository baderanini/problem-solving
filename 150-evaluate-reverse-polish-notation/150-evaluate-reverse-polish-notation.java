class Solution {
    public int evalRPN(String[] tokens) {
        Queue<String> q = new LinkedList<>();
        for(int i = tokens.length-1 ; i >= 0 ; i--)
            q.offer(tokens[i]);
        
        return dfs(q);
    }
    
    
    int dfs(Queue<String> tokens) {
        if(tokens.isEmpty())
            return 0;
        String token = tokens.poll();
        switch(token) {
                case "+": return dfs(tokens) + dfs(tokens);
                case "-": return -dfs(tokens) + dfs(tokens);
                case "*": return dfs(tokens) * dfs(tokens);
                case "/": {
                    int divider = dfs(tokens), divident = dfs(tokens); 
                    return divident/divider;
                }
                default: return Integer.parseInt(token);
            }
    }
}