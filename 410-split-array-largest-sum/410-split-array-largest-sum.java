class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for(int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        int l = max, r = sum;
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            int numSplits = splitOn(nums, mid);
            if(numSplits <= m) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    int splitOn(int[] nums, int targetSum) {
        int sum = 0, count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if(sum > targetSum) {
                sum = nums[i];
                count++;
            }
        }
        
        return sum == 0 ? count : count + 1;
    }
}