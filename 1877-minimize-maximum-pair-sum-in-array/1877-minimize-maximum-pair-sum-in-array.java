class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int l = 0, h = nums.length - 1;
        
        int min = Integer.MIN_VALUE;
        while(l < h) {
            min = Math.max(min, nums[l] + nums[h]);
            l++;
            h--;
        }
        return min;
    }
}