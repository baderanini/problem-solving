class Solution {
    public int minRefuelStops(int target, int availableFuel, int[][] stations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        
        
        int prevPos = 0, numStations = 0;
        for(int[] station: stations) {
            int currPos = station[0];
            availableFuel -= Math.min(target, currPos) - prevPos;
            prevPos = currPos;
            
            
            while(availableFuel < 0 && !pq.isEmpty()) {
                availableFuel += pq.poll();
                numStations++;
            }
        
            if(availableFuel < 0)
                return -1;
            if(target <= currPos)
                return numStations;
            
            pq.offer(station[1]);
        }
        
        while(availableFuel < target-prevPos && !pq.isEmpty()) {
            availableFuel += pq.poll();
            numStations++;
        }

        return availableFuel >= target-prevPos ? numStations : -1;
    }
}