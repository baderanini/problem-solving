class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1] - y[0], x[1] - x[0]));
        
        
        int max = Integer.MIN_VALUE;
        for(int[] point: points) {
            while(!pq.isEmpty() && point[0] - pq.peek()[0] > k)
                pq.poll();
            if(!pq.isEmpty()) {
                max = Math.max(max, calcEquation(point, pq.peek()));
            }
            pq.offer(point);
        }
        
        return max;
    }
    
    int calcEquation(int[] p1, int[] p2) {
        return p1[1] + p2[1] + Math.abs(p1[0] - p2[0]);
    }   
}