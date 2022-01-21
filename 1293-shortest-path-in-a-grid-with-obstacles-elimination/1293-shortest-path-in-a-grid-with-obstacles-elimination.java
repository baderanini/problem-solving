class State {
    int k;
    int i;
    int j;
    
    State(int k, int i, int j) {
        this.k = k;
        this.i = i;
        this.j = j;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(k, i, j);
    }
    
    @Override
    public boolean equals(Object t) {
        if(t instanceof State) {
            State tState = (State) t;
            return tState.k == this.k && tState.i == this.i && tState.j == this.j;
        }
        return false;
    }
}

class Solution {
    
    final int OBSTACLE = 1;
    
    public int shortestPath(int[][] grid, int k) {
        Queue<State> q = new LinkedList<>();
        
        q.offer(new State(k, 0, 0));
        Set<State> visited = new HashSet<>();
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++) {
                State currState = q.poll();
                if(visited.contains(currState))
                    continue;
                visited.add(currState);
                if(isValid(grid, currState)) {
                    boolean isObstacle = grid[currState.i][currState.j] == OBSTACLE;
                    if(currState.k > 0 || !isObstacle) {
                        if(currState.i == grid.length-1 && currState.j == grid[0].length-1)
                            return steps;
                        int[][] template = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
                        for(int[] temp: template)
                            q.offer(new State(isObstacle ? currState.k-1 : currState.k, currState.i + temp[0], currState.j + temp[1]));
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    boolean isValid(int[][] grid, State state) {
        return state.i >= 0 && state.j >= 0 && state.i < grid.length && state.j < grid[0].length;
    }
}