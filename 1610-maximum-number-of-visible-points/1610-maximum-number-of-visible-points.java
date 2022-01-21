class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        ArrayList<Double> angles = new ArrayList<>();
        
        int pointsAtCenter = 0;
        
        for(List<Integer> point: points) {
            if(equals(point, location))
                pointsAtCenter++;
            else {
                angles.add(calculateAngle(point, location));
            }
        }
        
        Collections.sort(angles);
        
        int anglesSize = angles.size(); 
        for (int i = 0 ; i < anglesSize ; i++)
            angles.add(angles.get(i) + 360); // we add the angles again at the end to simulate circularity, last angle can continue with fist angle.
        
        int windowStart = 0, maxAngles = pointsAtCenter;
        for(int windowEnd = 0 ; windowEnd < angles.size() ; windowEnd++) {
            while(angles.get(windowEnd) - angles.get(windowStart) > angle) {
                windowStart++;
            }
            int windowAnglesCount = windowEnd - windowStart + 1;
            maxAngles = Math.max(maxAngles, pointsAtCenter + windowAnglesCount);
        }
        
        return maxAngles;
    }
    
    double calculateAngle(List<Integer> point, List<Integer> reference) {
        return Math.toDegrees(Math.atan2(point.get(1)-reference.get(1), point.get(0)-reference.get(0)));
    }
    
    boolean equals(List<Integer> p1, List<Integer> p2) {
        return p1.get(0) == p2.get(0) && p1.get(1) == p2.get(1);
    }
}