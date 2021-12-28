
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
        PriorityQueue<Interval> minStart = new PriorityQueue<>((x, y) -> Integer.compare(x.start, y.start));
        
        for(Interval interval: ints)
            maxStart.offer(interval);

        for(int i = ints.length - 1 ; i >= 0 ; i--) {
            Interval curr = ints[i];
            while(!maxStart.isEmpty() && maxStart.peek().start >= curr.end)
                minStart.offer(maxStart.poll());
            
            if(!minStart.isEmpty())
                result[curr.index] = minStart.peek().index;
        }
        
        return result;
    }
}