class Solution {
    public int searchInsert(int[] nums, int target) {
        int st = 0, end = nums.length - 1;
        
        while(st <= end) {
            
            int mid = st + (end - st) / 2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                st = mid + 1;
            else
                end = mid - 1;
        }
        
        return st;
    }
}


/*


1 2 3 4 5 7

2
6

*/