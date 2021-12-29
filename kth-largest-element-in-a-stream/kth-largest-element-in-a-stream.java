class KthLargest {

    
    int k = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums)
            add(num);
    }

    
    public int add(int num) {
        if(pq.size() < k)
            pq.offer(num);
        else if(num > pq.peek()) {
            pq.remove();
            pq.offer(num);
        }
        
        return pq.peek();
    }
}