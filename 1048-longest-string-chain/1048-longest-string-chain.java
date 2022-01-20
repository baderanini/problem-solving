class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Set<String>> neighbors = new HashMap<>();
        
        for(String word1: words) {
            neighbors.putIfAbsent(word1, new HashSet<>());
            for(String word2: words) {
                if(word2.length() == word1.length() + 1 && isNeighbors(word1, word2))
                    neighbors.get(word1).add(word2);
                    
            }
        }
        
        
        int result = 0;
        Map<String, Integer> memo = new HashMap<>();
        for(String word: words)
            result = Math.max(result, dfs(word, neighbors, memo));
        
        return result;
    }

    int dfs(String word, Map<String, Set<String>> neighbors, Map<String, Integer> memo) {
        if(memo.containsKey(word))
            return memo.get(word);
        
        int result = 1;
        for(String neighbor: neighbors.get(word)) {
            result = Math.max(result, 1 + dfs(neighbor, neighbors, memo));
        }
        
        memo.put(word, result);
        return result;
    }
    
    public boolean isNeighbors(String word1, String word2) {
        int i, j;
        for(i = 0 , j = 0 ; i < word2.length() && j < word1.length() ; i++) {
            if(word2.charAt(i) == word1.charAt(j))
                j++;
        }
        
        return j == word1.length();
    }
}