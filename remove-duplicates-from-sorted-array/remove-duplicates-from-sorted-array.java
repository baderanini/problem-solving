class Solution {
    public int removeDuplicates(int[] nums) {
        int putIndex = 1, iterIndex;
        
        
        for(iterIndex = 1; iterIndex < nums.length ; iterIndex++) {
            if(nums[iterIndex] != nums[iterIndex-1])
                nums[putIndex++] = nums[iterIndex];
        }
        
        return putIndex;
    }
}