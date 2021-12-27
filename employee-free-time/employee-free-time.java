/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int[] indices = new int[schedule.size()];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(schedule.get(x).get(indices[x]).start, schedule.get(y).get(indices[y]).start));
        
        
        for(int i = 0 ; i < schedule.size() ; i++)
            pq.offer(i);
        
        List<Interval> res = new ArrayList<>();
        int maxPrevFinish = -1;
        while(!pq.isEmpty()) {
            int employee = pq.poll();
            Interval currInterval = schedule.get(employee).get(indices[employee]);
            
            if(maxPrevFinish != -1 && currInterval.start >= maxPrevFinish) {
                if(maxPrevFinish != currInterval.start)
                    res.add(new Interval(maxPrevFinish, currInterval.start));
            }
            indices[employee]++;
            if(indices[employee] < schedule.get(employee).size())
                pq.offer(employee);

            maxPrevFinish = Math.max(currInterval.end, maxPrevFinish);
        }

        return res;
    }
}