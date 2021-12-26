class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closestSum = 10000;
        for(int i = 0 ; i < nums.length ; i++) {
            int res = twoSum(nums, nums[i], i+1, nums.length - 1, target);
            if(res != Integer.MAX_VALUE && Math.abs(target - res) < Math.abs(target - closestSum)) {
                closestSum = res;
            }
        }
        
        return closestSum;
    }
    
    int twoSum(int[] nums, int num, int st, int end, int target) {
        int minDiff = Integer.MAX_VALUE, closestSum = Integer.MAX_VALUE;
        while(st < end) {
        
            
            int sum = num + nums[st] + nums[end];
        
            
            
            int diff = Math.abs(target - sum);
            if(diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
            }
            if(sum == target)
                break;
            else if(sum < target)
                st++;
            else
                end--;
        }
        
        return closestSum;
    }
}


/*

[1,1,-1,-1,3]
[-1,-1,1,1,3]

*/