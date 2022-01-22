class Time {
    int hour;
    int minute;
    
    Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    
    @Override
    public boolean equals(Object t) {
        if(t instanceof Time) {
            return ((Time) t).hour == this.hour && ((Time) t).minute == this.minute;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.hour, this.minute);
    }
}


class Solution {
    public int findMinDifference(List<String> timePoints) {
        Set<Time> times = new HashSet<>();
        for(String time: timePoints)
            if(!times.add(parseTime(time)))
                return 0;
            
        
        Time prevTime = null;
        int minDiff = Integer.MAX_VALUE;
        Time currTime = null, firstTime = null, lastTime = null;
        for(int i = 0 ; i < 24 ; i++) {
            for(int j = 0 ; j < 60 ; j++) {
                currTime = new Time(i, j);
                if(times.contains(currTime)) {
                    lastTime = currTime;
                    if(prevTime != null)
                        minDiff = Math.min(minDiff, calcDiff(currTime, prevTime));
                    else
                        firstTime = currTime;
                    prevTime = currTime;
                }
            }
        }

        minDiff = Math.min(minDiff, calcDiff(lastTime, firstTime));
        
        return minDiff;
    }
    
    int postProcess(int diff) {
        if(diff > 24*60/2)
            return 24*60 - diff;
        return diff;
    }
    
    int calcDiff(Time time, Time prev) {
        if(time.hour == prev.hour)
            return (postProcess(time.minute - prev.minute));
        else
            return postProcess((time.hour - prev.hour - 1) * 60 + (time.minute + 60 - prev.minute));
    } 
    
    Time parseTime(String timeString) {
        String[] tokens = timeString.split(":");
        return new Time(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
    }
}