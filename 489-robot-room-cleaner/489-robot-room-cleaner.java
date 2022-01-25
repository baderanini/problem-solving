/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */


class Solution {
    final int[] UP = {-1, 0}, RIGHT = {0, 1}, DOWN = {1, 0}, LEFT = {0, -1};
    int[][] movementTemplates = {UP, RIGHT, DOWN, LEFT};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, 0, 0, visited, 0);
    }
    
    void dfs(Robot robot, int dx, int dy, Set<String> visited, int dir) {
        String cellKey = dx + "," + dy;
        if(visited.contains(cellKey)) {
            robot.turnRight();
            robot.turnRight();
            robot.move();
            return;
        }
        visited.add(cellKey);
        robot.clean();
        
        for(int i = 0 ; i < 4 ; i++) {
            int newDir = (dir+i)%4;
            int[] movementTemplate = movementTemplates[newDir];
            if(robot.move()) {
                dfs(robot, dx+movementTemplate[0], dy+movementTemplate[1], visited, newDir);
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
        
        robot.turnRight();
        robot.turnRight();
        robot.move();
    }
}