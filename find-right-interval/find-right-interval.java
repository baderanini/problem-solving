
class Interval {
    int index;
    int start;
    int end;
    
    Interval(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        Interval[] ints = new Interval[intervals.length];
        
        for(int i = 0 ; i < intervals.length ; i++) {
            ints[i] = new Interval(i, intervals[i][0], intervals[i][1]);
        }
        
        Arrays.sort(ints, (x, y) -> Integer.compare(x.end, y.end));
        
        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);
        
        PriorityQueue<Interval> maxStart = new PriorityQueue<>((x, y) -> Integer.compare(y.start, x.start));
        
        for(Interval interval: ints)
            maxStart.offer(interval);

        Interval minStart = null;
        for(int i = ints.length - 1 ; i >= 0 ; i--) {
            Interval curr = ints[i];
            while(!maxStart.isEmpty() && maxStart.peek().start >= curr.end) {
                Interval nextMaxStart = maxStart.poll();
                if(minStart == null || nextMaxStart.start < minStart.start)
                    minStart = nextMaxStart;
            }
            
            if(minStart != null)
                result[curr.index] = minStart.index;
        }
        
        return result;
    }
}