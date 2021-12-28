class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Double.compare(distance(y), distance(x)));
        
        for(int i = 0 ; i < points.length ; i++) {
            int[] point = points[i];
            if(pq.size() < k)
                pq.offer(point);
            else if(distance(point) < distance(pq.peek())) {
                pq.poll();
                pq.offer(point);
            }
        }
        
        int[][] result = new int[k][];
        int index = 0;
        while(!pq.isEmpty())
            result[index++] = pq.poll();
        
        return result;
    }


public double distance(int[] point) {
	int x = point[0], y = point[1];
	return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

}
}