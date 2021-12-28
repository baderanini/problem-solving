class MedianFinder {
    
    PriorityQueue<Integer> lessOrEqualMed = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    PriorityQueue<Integer> greaterThatMed = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
    
    public MedianFinder() {}

    public void addNum(int num) {
        double median = findMedian();
        if(num > median)
            greaterThatMed.offer(num);
        else
            lessOrEqualMed.offer(num);
        rebalance();
    }
    
    void rebalance() {
        if(lessOrEqualMed.size() - 1 > greaterThatMed.size()) {
            greaterThatMed.offer(lessOrEqualMed.poll());
        } else if(greaterThatMed.size() > lessOrEqualMed.size()) {
            lessOrEqualMed.offer(greaterThatMed.poll());
        }
            
    }
    
    public double findMedian() {
        if(isEmpty())
            return 0; // this value does not matter when empty, balancing will take care.
        return shouldBeAvg() ? calcAvg() : lessOrEqualMed.peek();
    }
    
    boolean isEmpty() {
        return lessOrEqualMed.size() == 0 && greaterThatMed.size() == 0;
    }
    
    double calcAvg() {
        return (lessOrEqualMed.peek() + greaterThatMed.peek()) / 2.0;
    }
    
    boolean shouldBeAvg() {
        return lessOrEqualMed.size() == greaterThatMed.size();
    }
}