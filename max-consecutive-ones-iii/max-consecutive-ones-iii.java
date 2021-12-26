class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0, oneCount = 0;
        
        int st = 0;
        int max = 0;
        for(int end = 0 ; end < nums.length ; end++) {
            if(nums[end] == 0)
                zeroCount++;
            else
                oneCount++;
            while(zeroCount > k) {
                int stItem = nums[st];
                if(stItem == 0)
                    zeroCount--;
                else
                   oneCount--; 
                st++;
            }
            
            max = Math.max(max, end - st + 1);
        }
        
        return max;
    }
}