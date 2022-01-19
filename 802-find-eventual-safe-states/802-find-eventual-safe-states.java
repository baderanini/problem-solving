class Solution {
    public List<Integer> eventualSafeNodes(int[][] graphArr) {
        Map<Integer, Set<Integer>> graph = buildGraph(graphArr);
        int[] memo = new int[graph.size()];
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < graph.size() ; i++) {
            if(dfs(graph, i, memo))
                result.add(i);
        }
        
        return result;
    }
    
    final int IN_CALL_STACK = 1, TRUE_RESULT = 2, FALSE_RESULT = 3;
    
    boolean dfs(Map<Integer, Set<Integer>> graph, int node, int[] memo) {        
        
        if(memo[node] == IN_CALL_STACK || memo[node] == FALSE_RESULT) {
            memo[node] = FALSE_RESULT;
            return false;
        } else if(memo[node] == TRUE_RESULT)
            return true;

        memo[node] = IN_CALL_STACK;
        
        boolean result = true;
        for(int neighbor: graph.get(node)) {
            if(!dfs(graph, neighbor, memo)) {
                result = false;
                break;
            }   
        }
        
        memo[node] = result ? TRUE_RESULT : FALSE_RESULT;
        return result;
    }
    
    Map<Integer, Set<Integer>> buildGraph(int[][] graphArr) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < graphArr.length ; i++) {
            graph.putIfAbsent(i, new HashSet<>());
            for(int j = 0 ; j < graphArr[i].length ; j++) {
                int neighbor = graphArr[i][j];
                graph.get(i).add(neighbor);
            }
        }
        
        return graph;
    }
}