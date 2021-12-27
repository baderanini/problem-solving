class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++) {
            while(i+1 != nums[i]) {
                int j = nums[i] - 1;
                if(nums[j] == nums[i])
                    break;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        
        return nums[nums.length - 1];
    }
}