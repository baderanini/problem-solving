class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2) -> Integer.compare(distance(k2, x), distance(k1, x)));
        for(int i = 0 ; i < arr.length ; i++) {
            if(pq.size() < k)
                pq.offer(arr[i]);
            else if(distance(pq.peek(), x) > distance(arr[i], x)) {
                pq.remove();
                pq.offer(arr[i]);
            }
        }
        
        LinkedList<Integer> lessThanX = new LinkedList<>();
        LinkedList<Integer> moreThanX = new LinkedList<>();
        
        while(!pq.isEmpty()) {
            if(pq.peek() > x)
                moreThanX.addFirst(pq.poll());
            else
                lessThanX.add(pq.poll());
                
        }
        
        LinkedList<Integer> res = new LinkedList<>();
        res.addAll(lessThanX);
        res.addAll(moreThanX);
        
        return res;
    }
    
    int distance(int x, int y) {
        return Math.abs(x-y);
    }
}