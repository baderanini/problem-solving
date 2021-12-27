class Solution {
    public int missingNumber(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++) {
            while(nums[i] != i) {
                int j = nums[i];
                if(j >= nums.length)
                    break;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }
}


/*

[3,0,1]





*/