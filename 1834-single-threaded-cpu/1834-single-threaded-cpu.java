class Solution {
    public int[] getOrder(int[][] tasks) {
        
        PriorityQueue<Integer> all = new PriorityQueue<>((x, y) -> Integer.compare(tasks[x][0], tasks[y][0]));
        
        PriorityQueue<Integer> prior = new PriorityQueue<>(new Comparator<Integer> () {
            @Override
            public int compare(Integer t1, Integer t2) {
                int compareOnEnque = Integer.compare(tasks[t1][1], tasks[t2][1]);
                if(compareOnEnque != 0)
                    return compareOnEnque;
                else
                    return Integer.compare(t1, t2);
            }
        });
        
        int[] result = new int[tasks.length];
        int resultIndex = 0;
        
        for(int i = 0 ; i < tasks.length ; i++) {
            all.offer(i);
        }
        
        int time = 0;
        while(true) {
            if(!all.isEmpty() && prior.isEmpty())
                time = Math.max(time, tasks[all.peek()][0]);
            while(!all.isEmpty() && tasks[all.peek()][0] <= time)
                prior.offer(all.poll());
            if(prior.isEmpty())
                break;
            int toBeExecuted = prior.poll();
            result[resultIndex++] = toBeExecuted;
            time += tasks[toBeExecuted][1];
        }
        
        return result;
    }
}