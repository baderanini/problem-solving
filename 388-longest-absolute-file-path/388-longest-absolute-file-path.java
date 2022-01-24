class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        Queue<String> linesQueue = new LinkedList<>();
        for(String line: lines)
            linesQueue.offer(line);
        
        int res = 0;
        while(!linesQueue.isEmpty() && depth(linesQueue.peek()) == 0) {
            res = Math.max(res, dfs(linesQueue, -1, 0));
        }
        return res;
    }
    
    int dfs(Queue<String> linesQueue, int parentDepth, int runningLength) {
        String line = linesQueue.peek();
        int pureLength = pureLength(line);
        runningLength += pureLength;
        int depth = depth(line);
    
        if(depth > parentDepth) {
            linesQueue.poll();
            if(isFile(line))
                return runningLength;
            int res = 0;
            while(!linesQueue.isEmpty() && depth(linesQueue.peek()) > depth) {
                res = Math.max(res, dfs(linesQueue, depth, runningLength + 1));
            }
            return res;
        }
        return 0;
    }
    
    boolean isFile(String line) {
        return line.contains(".");
    }
    int depth(String s) {
        return s.length() - pureLength(s);
    }
    
    int pureLength(String line) {
        int index = 0;
        while(index < line.length() && line.charAt(index) == '\t')
            index++;
        
        return line.length() - index;
    }
}