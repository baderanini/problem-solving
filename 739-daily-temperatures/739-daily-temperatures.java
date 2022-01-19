class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        for(int i = 1 ; i < temperatures.length ; i++) {
            int currTemp = temperatures[i];
            while(!deque.isEmpty() && temperatures[deque.getLast()] < currTemp) {
                res[deque.getLast()] = i - deque.getLast();
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        return res;
    }
}