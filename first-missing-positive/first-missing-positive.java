class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++) {
            while(nums[i] != i+1) {
                int j = nums[i] - 1;
                if(j >= nums.length || j < 0 || nums[i] == nums[j])
                    break;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(i+1 != nums[i])
                return i+1;
        }
        
        return nums.length + 1;
    }
}