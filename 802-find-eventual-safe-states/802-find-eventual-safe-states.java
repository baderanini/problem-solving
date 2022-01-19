class Solution {
    public List<Integer> eventualSafeNodes(int[][] graphArr) {
        Map<Integer, Set<Integer>> graph = buildGraph(graphArr);
        Map<Integer, Integer> memo = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < graph.size() ; i++) {
            if(dfs(graph, i, memo))
                result.add(i);
        }
        
        return result;
    }
    
    final int IN_CALL_STACK = 0, TRUE_RESULT = 1, FALSE_RESULT = 2;
    
    boolean dfs(Map<Integer, Set<Integer>> graph, int node, Map<Integer, Integer> memo) {        
        if(memo.containsKey(node)) {
            if(memo.get(node) == IN_CALL_STACK || memo.get(node) == FALSE_RESULT) {
                memo.put(node, FALSE_RESULT);
                return false;
            } else
                return true;
        }

        memo.put(node, IN_CALL_STACK);
        
        boolean result = true;
        for(int neighbor: graph.get(node)) {
            if(!dfs(graph, neighbor, memo)) {
                result = false;
                break;
            }   
        }
        
        memo.put(node, result ? TRUE_RESULT : FALSE_RESULT);
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