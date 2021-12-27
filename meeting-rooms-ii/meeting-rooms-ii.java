class Solution {
    public int minMeetingRooms(int[][] ins) {
        int res = Integer.MIN_VALUE;
        Arrays.sort(ins, (x, y) -> Integer.compare(x[0], y[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
        
        
        for(int[] interval: ins) {
            while(!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
            res = Math.max(res, pq.size());
        }
        
        return res;
    }
}




/*



*/