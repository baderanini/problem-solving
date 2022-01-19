class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        
        while(l <= r) {
            int pivotNewIndex = patitionAroundPivot(nums, l, r);
            if(pivotNewIndex == nums.length - k)
                return nums[pivotNewIndex];
            else if(pivotNewIndex < nums.length - k) {
                l = pivotNewIndex + 1;
            } else {
                r = pivotNewIndex - 1;
            }
        }
        
        return -1;
    }
    
    int patitionAroundPivot(int[] nums,int l, int r) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(r-l+1) + l;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, r);
        int newPivotIndex = l;
        for(int i = l ; i < r ; i++) {
            if(nums[i] < pivot) {
                swap(nums, newPivotIndex++, i);
            } 
        }
        swap(nums, newPivotIndex, r);
        
        return newPivotIndex;
    }
    
    void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}