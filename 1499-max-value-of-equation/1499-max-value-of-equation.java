class Max {
    int val;
    int index;
    
    Max(int val, int index) {
        this.val = val;
        this.index = index;
    }
    
    @Override
    public String toString() {
        return "val: " + val + " index: " + index;
    }
}

class Solution {
    
    
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1] - y[0], x[1] - x[0]));
        
        
        int max = Integer.MIN_VALUE;
        for(int[] point: points) {
            while(!pq.isEmpty() && point[0] - pq.peek()[0] > k)
                pq.poll();
            if(!pq.isEmpty()) {
                max = Math.max(max, calcEquation(point, pq.peek()));
            }
            pq.offer(point);
        }
        
        return max;
    }
    
    int calcEquation(int[] p1, int[] p2) {
        return p1[1] + p2[1] + Math.abs(p1[0] - p2[0]);
    }
    
    
    
    
    
    /**************************************************************************************************/

//     public int findMaxValueOfEquation(int[][] points, int k) {
//         Max[] leftMaxes = new Max[points.length], rightMaxes = new Max[points.length];
//         Stack<Max> leftStack = new Stack(), rightStack = new Stack();
        
//         for(int i = 0 ; i < points.length ; i++) {
//             Max currMax = new Max(Integer.MIN_VALUE, -1);
//             while(!leftStack.isEmpty() && leftStack.peek().val <= points[i][1] && points[leftStack.peek().index][0] >= points[i][0] - k) {
//                 if(leftStack.peek().val > currMax.val)
//                     currMax = leftStack.peek();
//                 leftStack.pop();
//             }
//             if(!leftStack.isEmpty() && points[leftStack.peek().index][0] >= points[i][0] - k)
//                 if(leftStack.peek().val > currMax.val)
//                     currMax = leftStack.peek();
//             leftMaxes[i] = currMax;
//             leftStack.push(new Max(points[i][1], i));
//         }
        
//         for(int i =  points.length-1 ; i >= 0 ; i--) {
//             Max currMax = new Max(Integer.MIN_VALUE, -1);
//             while(!rightStack.isEmpty() && rightStack.peek().val <= points[i][1] && points[i][0] >= points[rightStack.peek().index][0] - k) {
//                 if(rightStack.peek().val > currMax.val)
//                     currMax = rightStack.peek();
//                 rightStack.pop();
//             }
//             if(!rightStack.isEmpty() && points[i][0] >= points[rightStack.peek().index][0] - k)
//                 if(rightStack.peek().val > currMax.val)
//                     currMax = rightStack.peek();
//             rightMaxes[i] = currMax;
//             rightStack.push(new Max(points[i][1], i));
//         }
        
        
//         System.out.println(Arrays.toString(leftMaxes));
//         System.out.println(Arrays.toString(rightMaxes));
        
//         int res = Integer.MIN_VALUE;
//         for(int i = 0 ; i < points.length ; i++) {
//             Max leftMax = leftMaxes[i], rightMax = rightMaxes[i];
            
//             int leftRes = leftMax.index == -1 ? Integer.MIN_VALUE : points[i][1] + leftMax.val + Math.abs(points[i][0] - points[leftMax.index][0]);
//             int rightRes = rightMax.index == -1 ? Integer.MIN_VALUE : points[i][1] + rightMax.val + Math.abs(points[i][0] - points[rightMax.index][0]);
            
//             System.out.println("for index " + i + " left: " + leftRes + " ,right: " + rightRes);
            
//             int currRes = Math.max(leftRes, rightRes);
//             res = Math.max(res, currRes);
//         }
        
//         return res;
//     }
    
//     public int findMaxValueOfEquation(int[][] points, int k) {
//         Max[] leftMaxes = new Max[points.length], rightMaxes = new Max[points.length];
        
//         int maxTillNow = Integer.MIN_VALUE, maxTillNowIndex = -1;
        
        
        
//         for(int i =  0 ; i < points.length ; i++) {
//             leftMaxes[i] = new Max(maxTillNow, maxTillNowIndex);
//             if(points[i][1] >= maxTillNow) {
//                 maxTillNow = points[i][1];
//                 maxTillNowIndex = i;
//             }
//         }
        
//         maxTillNow = Integer.MIN_VALUE;
//         maxTillNowIndex = -1;
//         for(int i =  points.length-1 ; i >= 0 ; i--) {
//             rightMaxes[i] = new Max(maxTillNow, maxTillNowIndex);
//             if(points[i][1] >= maxTillNow) {
//                 maxTillNow = points[i][1];
//                 maxTillNowIndex = i;
//             }
//         }
        
//         System.out.println(Arrays.toString(leftMaxes));
//         System.out.println(Arrays.toString(rightMaxes));
        
//         int res = Integer.MIN_VALUE;
//         for(int i = 0 ; i < points.length ; i++) {
//             Max leftMax = leftMaxes[i], rightMax = rightMaxes[i];
            
//             int leftRes = leftMax.index == -1 ? Integer.MIN_VALUE : points[i][1] + leftMax.val + Math.abs(i - leftMax.index);
//             int rightRes = rightMax.index == -1 ? Integer.MIN_VALUE : points[i][1] + rightMax.val + Math.abs(i - rightMax.index);
            
//             int currRes = Math.max(leftRes, rightRes);
//             res = Math.max(res, currRes);
//         }
        
//         return res;
//     }
}


/*


0, 1, 2, 3, 4, 5


[[1,3],[2,0],[5,10],[6,-10]]



|     x
|
|
|
|
|
|     
| x   
|           
|__x_____________
|
|
|
|
|
|
|
|
|
|      x








*/