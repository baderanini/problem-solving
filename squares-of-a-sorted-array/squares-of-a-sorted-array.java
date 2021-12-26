class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int st = 0, end = nums.length - 1;
        
        int resIter = end;
        while(st <= end) {
            if(Math.abs(nums[st]) > Math.abs(nums[end]))
                res[resIter--] = (int) Math.pow(nums[st++], 2);
            else
                res[resIter--] = (int) Math.pow(nums[end--], 2);
        }
        
        return res;
    }
}


/*

-4,-1,0,3,10


*/