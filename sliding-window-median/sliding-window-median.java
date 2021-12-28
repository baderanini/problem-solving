class Solution {
    
    
    PriorityQueue<Integer> lessOrEqualMed = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    PriorityQueue<Integer> greaterThanMed = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        for(int i = 0 ; i < nums.length ; i++) {
            addNum(nums[i]);            
            if(i >= k-1) {
                medians[i-k+1] = median();
                removeNum(nums[i-k+1]);
            }
        }
        
        return medians;
    }
    
    void addNum(int num) {
        if(num > median())
            greaterThanMed.offer(num);
        else
            lessOrEqualMed.offer(num);
        
        rebalance();
    }
    
    void rebalance() {
        if(lessOrEqualMed.size() - 1 > greaterThanMed.size())
            greaterThanMed.offer(lessOrEqualMed.poll());
        else if (greaterThanMed.size() > lessOrEqualMed.size())
            lessOrEqualMed.offer(greaterThanMed.poll());
    }
    
    
    double median() {
        if(isEmpty())
            return 0;
        return shouldBeAvg() ? ((long) lessOrEqualMed.peek() + (long) greaterThanMed.peek()) / 2.0 : lessOrEqualMed.peek();
    }
    
    boolean shouldBeAvg() {
        return lessOrEqualMed.size() == greaterThanMed.size();
    }
    
    boolean isEmpty() {
        return lessOrEqualMed.size() == 0 && greaterThanMed.size() == 0;
    }
    
    void removeNum(int num) {
        if(num > median())
            greaterThanMed.remove(num);
        else
            lessOrEqualMed.remove(num);
        rebalance();
    }
}