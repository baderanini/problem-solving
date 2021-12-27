class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if(intervals.length == 0)
            return new int[][] {newInterval};
        
        int firstOverlappingIndex = -1, lastOverlappingIndex = -1;
        for(int i = 0 ; i < intervals.length ; i++) {
            if(isOerlapping(intervals[i], newInterval)) {
                if(firstOverlappingIndex == -1) {
                    firstOverlappingIndex = i;
                }
                lastOverlappingIndex = i;
            }
        }
        
                
        List<int[]> resList = new ArrayList<>();
        if(newInterval[1] < intervals[0][0])
            resList.add(newInterval);
            
        for(int i = 0 ; i < intervals.length ; i++) {
            if(i == firstOverlappingIndex) {
                resList.add(new int[] {Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])});
            } else if(i == lastOverlappingIndex) {
                resList.get(resList.size() - 1)[1] = Math.max(newInterval[1], intervals[i][1]);
            } else if(i < firstOverlappingIndex || i > lastOverlappingIndex) {
                resList.add(intervals[i]);
            }
            
            if(firstOverlappingIndex == -1 && i < intervals.length-1 && newInterval[0] > intervals[i][1] && newInterval[1] < intervals[i+1][0])
                resList.add(newInterval);
        }
        
        if(newInterval[0] > intervals[intervals.length - 1][1])
            resList.add(newInterval);
        
        int index = 0;
        
        int[][] res = new int[resList.size()][];
        for(int[] interval: resList) {
            res[index++] = interval;
        }
        
        return res;
    }
    
    boolean isOerlapping(int[] fInterval, int[] sInterval) {
        return !(fInterval[0] > sInterval[1]) && !(sInterval[0] > fInterval[1]);
    }
}

/*

bs to insert, then m

*/