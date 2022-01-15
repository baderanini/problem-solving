class Solution {
    public boolean isValidSerialization(String preorder) {
        Queue<Integer> q = new LinkedList<>();
        String[] tokens = preorder.split(",");
        for(String token: tokens)
            if(token.equals("#"))
                q.offer(null);
            else
                q.offer(Integer.parseInt(token));
        
        return dfs(q) && q.isEmpty();
    }
    
    boolean dfs(Queue<Integer> q) {
        if(q.isEmpty())
            return false;
        
        Integer currVal = q.poll();
        if(currVal == null)
            return true;
        
        return dfs(q) && dfs(q);
    }
}