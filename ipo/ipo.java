class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((x,y) -> Integer.compare(capital[x], capital[y]));
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((x,y) -> Integer.compare(profits[y], profits[x]));
        
        for(int i = 0 ; i < profits.length ; i++) {
            minCapital.offer(i);
        }
        
        for(int i = 0 ; i < k ; i++) {
            while(!minCapital.isEmpty() && capital[minCapital.peek()] <= w) {
                maxProfit.offer(minCapital.poll());
            }
            
            if(!maxProfit.isEmpty())
                w += profits[maxProfit.poll()];
            else
                break;
        }
        
        return w;
    }
}