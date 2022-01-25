
class Cell {
    int i;
    int j;
    int mods;
    
    Cell(int i, int j, int mods) {
        this.i = i;
        this.j = j;
        this.mods = mods;
    }
    
    @Override
    public boolean equals(Object c) {
        return ((Cell) c).i == i && ((Cell) c).j == j; 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
class Solution {
    
    final int RIGHT = 1, LEFT = 2, DOWN = 3, UP = 4;
    
    public int minCost(int[][] grid) {
        PriorityQueue<Cell> q = new PriorityQueue<>((x, y) -> Integer.compare(x.mods, y.mods));
        Cell initialCell = new Cell(0, 0, 0);
        q.offer(initialCell);
        Set<Cell> visited = new HashSet<>();
        
        while(!q.isEmpty()) {
            Cell curr = q.poll();
            if(!isValid(grid, curr) || visited.contains(curr))
                continue;
            if(curr.i == grid.length-1 && curr.j == grid[0].length-1)
                return curr.mods;
            visited.add(curr);
            offerVariations(grid, q, curr);
            
        }
        return -1;
    }
    
    boolean isValid(int[][] grid, Cell cell) {
        return cell.i >= 0 && cell.j >= 0 && cell.i < grid.length && cell.j < grid[0].length;
    }
    
    void offerVariations(int[][] grid, Queue<Cell> q, Cell c) {
        int dir = grid[c.i][c.j];
        q.offer(new Cell(c.i-1, c.j, dir == UP ? c.mods : c.mods+1));
        q.offer(new Cell(c.i+1, c.j, dir == DOWN ? c.mods : c.mods+1));
        q.offer(new Cell(c.i, c.j-1, dir == LEFT ? c.mods : c.mods+1));
        q.offer(new Cell(c.i, c.j+1, dir == RIGHT ? c.mods : c.mods+1));
    }
}