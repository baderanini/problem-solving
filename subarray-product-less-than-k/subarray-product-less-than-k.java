class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int st = 0;
        
        int windowProduct = 1;
        int res = 0;
        for(int end = 0 ; end < nums.length ; end++) {
            windowProduct *= nums[end];
            
            while(windowProduct >= k && st <= end) {
                windowProduct /= nums[st++];
            }
            
            int windowSize = end - st + 1;
            if(st<nums.length)
                res+=windowSize;
            
        }
        
        return res;
    }
}


/*

1 2 3 4 5


*/