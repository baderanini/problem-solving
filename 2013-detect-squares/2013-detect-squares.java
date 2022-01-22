class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object p) {
        return ((Point) p).x == x && ((Point) p).y == y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class DetectSquares {

    Map<Point, Integer> pointFreqs; 
    public DetectSquares() {
        pointFreqs = new HashMap<>();
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        pointFreqs.put(p, pointFreqs.getOrDefault(p, 0) + 1);
    }
    
    public int count(int[] point) {
        Point p1 = new Point(point[0], point[1]);
        
        int result = 0;
        for(Map.Entry<Point, Integer> entry: pointFreqs.entrySet()) {
            Point p2 = entry.getKey();
            int freq = entry.getValue();
            Point p3, p4;
            if(p1.y == p2.y || p1.x == p2.x || Math.abs(p1.y-p2.y) != Math.abs(p1.x-p2.x)) {
                continue;
            } else if((double)(p1.y-p2.y)/(p1.x-p2.x) > 0) {
                p3 = new Point(Math.max(p1.x, p2.x), Math.min(p1.y, p2.y));
                p4 = new Point(Math.min(p1.x, p2.x), Math.max(p1.y, p2.y));
            } else {
                p3 = new Point(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
                p4 = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
            }
            
            int possibilities = freq * pointFreqs.getOrDefault(p3, 0) * pointFreqs.getOrDefault(p4, 0);
            result += possibilities;
        }
        
        return result;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */