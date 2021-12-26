class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        
        int firstLeftNonAsc = -1;
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] < nums[i-1]) {
                int min = nums[i];
                firstLeftNonAsc = i;
                for(int j = i + 1 ; j < nums.length ; j++) {
                    if(nums[j] < min) {
                        min = nums[j];
                        firstLeftNonAsc = j;
                    }
                }
                break;
            }
        }
        if(firstLeftNonAsc == -1)
            return 0;
        int left = -1;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > nums[firstLeftNonAsc]) {
                left = i;
                break;
            }
        }
        
        int firstRightNonDesc = -1;
        for(int i = nums.length - 2 ; i >= 0 ; i--) {
            if(nums[i] > nums[i+1]) {
                int max = nums[i];
                firstRightNonDesc = i;
                for(int j = i - 1 ; j >= 0 ; j--) {
                    if(nums[j] > max) {
                        max = nums[j];
                        firstRightNonDesc = j;
                    }
                }
                break;
            }
        }
        
        int right = -1;
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            if(nums[i] < nums[firstRightNonDesc]) {
                right = i;
                break;
            }
        }
        
        return right - left + 1;
    }
}