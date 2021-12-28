class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = calcFreqs(nums);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(freqs.get(x), freqs.get(y)));
        
        for(int num: freqs.keySet()) {
            if(pq.size() < k)
                pq.offer(num);
            else if(freqs.get(pq.peek()) < freqs.get(num)) {
                pq.remove();
                pq.offer(num);
            }
        }
        
        int[] result = new int[k];
        int index = 0;
        
        while(!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        
        return result;
    }
    
    Map<Integer, Integer> calcFreqs(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for(int num: nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        
        return freqs;
    }
}